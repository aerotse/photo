package com.xth.project.photo;

import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by xieth on 2019/3/5.
 */
public class LiKaiFuBlogReading implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(2000);
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final String startPage = "http://blog.sina.com.cn/s/articlelist_1197161814_0_1.html"; // 目录页

    public static void main(String[] args) {
        Spider.create(new LiKaiFuBlogReading())
                .addPipeline(new JsonFilePipeline("E:/likaifu"))
                .addUrl(startPage)
                .thread(3)
                .run();
    }

    @Override
    public void process(Page page) {
        String url = page.getRequest().getUrl();
        System.out.println("url:" + url);

        if(url.startsWith("http://blog.sina.com.cn/s/articlelist_1197161814_0_1.html")){
            //提取列表
            List<String> links = page.getHtml().xpath("//span[@class='atc_title']/a/@href").all();
            page.addTargetRequests(links);

            links = page.getHtml().xpath("//ul[@class='SG_pages']/li/a/@href").all();
            page.addTargetRequests(links);

            page.setSkip(true);

        }else if (url.startsWith("http://blog.sina.com.cn/s")){
            String title = page.getHtml().xpath("//h1[@class='h1_tit']/text()").get();

            String content = page.getHtml().xpath("//div[@class='BNE_cont']/allText()").get();

            String timeAndSource = page.getHtml().xpath("//span[@class='time_SG_txtc']/text()").get();

            if(StringUtils.isBlank(title) && StringUtils.isBlank(content)){
                title = page.getHtml().xpath("//div[@class='articalTitle']/h2/text()").get();

                content = page.getHtml().xpath("//div[@id='sina_keyword_ad_area2']/allText()").get();

                timeAndSource = page.getHtml().regex("\\d{4}-\\d{2}-\\d{2}\\s\\d+.\\d+.\\d+").toString();

            }

            page.putField("title", title);
            page.putField("content", content);
            page.putField("timeAndSource", timeAndSource);
            page.putField("url", page.getRequest().getUrl());
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
