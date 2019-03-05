package com.xth.project.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Service
public class NewsPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {

    }
//    @Autowired
//    private NewsService newsService;
//
//    @Override
//    public void process(ResultItems resultItems, Task task) {
//        News news = (News) resultItems.get("news");
//        if (!newsService.isExist(news)) {
//            newsService.create(news);
//        }
//    }
}