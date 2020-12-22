package com.gitee.code4fun.processor;

import com.gitee.code4fun.pipeline.KafkaPipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

public class ChyxxBankPageProcessor implements PageProcessor {

    private static Logger logger = LoggerFactory.getLogger(ChyxxBankPageProcessor.class);

    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(1000)
            .addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");

    @Override
    public void process(Page page) {
        String pageTitle = page.getHtml().xpath("//title/text()").toString();
        logger.info("pageTitle:{}",pageTitle);
        List<String> urls = page.getHtml().links().all();
        List<String> nextLinks = new ArrayList<>(urls.size()/2);
        for(String url : urls){
            if(url.contains("data/20")){
                nextLinks.add(url);
            }
        }
        page.addTargetRequests(nextLinks);
        page.putField("title",pageTitle);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args){
        Spider.create(new ChyxxBankPageProcessor())
                .addUrl("https://www.chyxx.com/data/yinhang/")
                .addPipeline(new KafkaPipeline("page_visits5","192.168.9.16:9093,192.168.9.16:9095,192.168.9.16:9097"))
                .thread(1)
                .run();
    }

}
