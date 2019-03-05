package com.xth.project.photo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created by xieth on 2019/3/4.
 */
public class JsoupTest {
    public static void main(String[] args) throws IOException {
//        Document doc = Jsoup.connect("https://blog.csdn.net/qq_41441210/article/details/79965444").get();
//        String title = doc.title();
//        System.out.println(title);
//
//        File input = new File("/tmp/input.html");
//        Document doc1 = Jsoup.parse(input, "UTF-8", "http://example.com/");
//        Elements links = doc.select("a[href]"); //带有href属性的a元素
//        Elements pngs = doc.select("img[src$=.png]");
//        Element masthead = doc.select("div.masthead").first();
//        //class等于masthead的div标签
//
//        Elements resultLinks = doc.select("h3.r > a"); //在h3元素之后的a元素


        Document doc = Jsoup.connect("https://blog.csdn.net/qq_41441210/article/details/79965444").get();

        Element link = doc.select("a").first();
        String relHref = link.attr("href"); // == "/"
        String absHref = link.attr("abs:href"); // "http://www.open-open.com/"
        System.out.println("relHref:" + relHref);
        System.out.println("absHref:" + absHref);
    }

}
