package com.xth.project.photo;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by xieth on 2019/3/7.
 */
public class CSDNBlogReading implements PageProcessor{

    private static final String BLOG_URL = "https://blog.csdn.net/yixiao1874/article/list/1?";

    private static final String BLOG_URL_START = "https://blog.csdn.net/yixiao1874/article/list/";

    private static final String BLOG_POST = "https://blog.csdn.net\\/yixiao1874\\/article\\/details\\/\\d+";

    private static final String PAGE_LIST = "https://blog.csdn.net/yixiao1874/article/list/\\d+\\?";

    private static final String timeRegex = "\\d{4}-\\d{2}-\\d{2}\\s\\d+\\:\\d+\\:\\d+";

    private int maxPage = 30;

    private boolean isAdd = false;

    private Site site = Site.me()
                            .setRetryTimes(3)
                            .setSleepTime(3000)
                            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    public static void main(String[] args) {
        Spider.create(new CSDNBlogReading())
                .addPipeline(new JsonFilePipeline("D:/CSDNBlog/3"))
                .addUrl(BLOG_URL)
                .thread(3)
                .run();
    }

    @Override
    public void process(Page page) {
        String url = page.getRequest().getUrl();
        if(url.startsWith(BLOG_URL_START)){
            page.addTargetRequests(page.getHtml().xpath("//div[@class='article-item-box csdn-tracking-statistics']/h4/a/@href").all());

//            List<String> listPage = page.getHtml().xpath("//li[@class='ui-pager']/text()").all();
//            String number = page.getHtml().xpath("//li[@class='page-item active']//a[@class='page-link']/text()").toString();

            if(!isAdd){
                while(maxPage > 0){
                    page.addTargetRequest(BLOG_URL_START + maxPage + "?");
                    maxPage--;
                }
                isAdd = true;
            }
            page.setSkip(true);
        }else if(page.getUrl().regex(BLOG_POST).match()){
            String title = page.getHtml().xpath("//div[@class='article-title-box']/h1/text()").get();
            String content = page.getHtml().xpath("//div[@class='htmledit_views']/allText()").get();
            String putTime = page.getHtml().regex(timeRegex).toString();

            page.putField("title", title);
            page.putField("content", content);
            page.putField("putTime", putTime);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
