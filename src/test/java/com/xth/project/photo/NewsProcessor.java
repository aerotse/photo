package com.xth.project.photo;

import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xieth on 2019/3/4.
 */
@Service
public class NewsProcessor implements PageProcessor {
    // 入口url
    public static final String URL_ENTER = "http://bj.people.com.cn/";
    // 类别导航
    private String URL_INDEX = "http://bj\\.people\\.com\\.cn/GB/\\d+/index\\.html";
    // 列表
    private String URL_LIST = "http://bj\\.people\\.com\\.cn/GB/\\d+/index\\d*\\.html";
    // 文章
    private String URL_POST = "http://bj\\.people\\.com\\.cn/n2/2016/\\d+/.+\\.html";
    // 设置
    private Site site = Site.me().setRetryTimes(10).setSleepTime(1000).setCycleRetryTimes(3);

    @Override
    public void process(Page page) {
        System.out.println("--------------------------------------------");
        if (page.getUrl().get().equals(URL_ENTER)) {
            // 类别
            page.addTargetRequests(page.getHtml().xpath("//div[@class='pd_nav w1000 white  clear clearfix']").links().regex(URL_INDEX).all());
            System.out.println("enter1"+page.getUrl().get());
        } else {
            System.out.println("enter2"+page.getUrl().get());
            // 列表页
            if (page.getUrl().regex(URL_LIST).match()) {
                page.addTargetRequests(page.getHtml().xpath("//div[@class='ej_list_box clear']").links().regex(URL_POST).all());
                page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
            } else {
                // 匹配当前域名
                String currentDomain = page.getUrl().regex("http.+\\.com\\.cn").toString();
                String title = page.getHtml().xpath("//div[@class='clearfix w1000_320 text_title']/h1/text()").toString();
                String contentTime = page.getHtml().xpath("//div[@class='box01']/div[@class='fl']/text()").regex("\\d{4}年\\d{2}月\\d{2}日\\s*\\d{2}:\\d{2}").toString();
                String content = page.getHtml().xpath("//div[@class='box_con']").toString();
                List<String> imgList = page.getHtml().xpath("//div[@class='box_con']//img/@src").all();
                List<String> result = new ArrayList<>();
                for (String img : imgList) {
                    // 匹配是否是绝对路劲
                    Pattern r = Pattern.compile("^http");
                    Matcher m = r.matcher(img);
                    if (!m.find()) {
                        // 不是绝对路径 拼接当前域名
                        result.add(currentDomain + img);
                    } else {
                        result.add(img);
                    }
                }

                System.out.println("title:" + title);
                System.out.println("content:" + content);

            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new NewsProcessor()).addUrl("http://bj.people.com.cn/").addPipeline(new ConsolePipeline()).run();

    }
}