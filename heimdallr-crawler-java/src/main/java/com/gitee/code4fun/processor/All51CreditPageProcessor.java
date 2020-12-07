package com.gitee.code4fun.processor;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/30.
 */
public class All51CreditPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        List<String> allLinks = html.links().all();
        List<String> nextLinks = new ArrayList<>(allLinks.size()/2);
        allLinks.forEach(link -> {
            if(link.contains("bbs.51credit.com")){
                nextLinks.add(link);
            }
        });
    allLinks.clear();
        page.addTargetRequests(nextLinks);
        List<String> links = html.xpath("//th[@class='new']/a[@class='s xst']").links().all();
        List<String> linkTitles = html.xpath("//th[@class='new']/a[@class='s xst']/text()").all();
        for (int i = 0; i < links.size(); i++) {
            System.out.println("link:"+links.get(i)+",title:"+linkTitles.get(i));
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new All51CreditPageProcessor())
                .addUrl("https://bbs.51credit.com/")
                .thread(5)
                .run();
    }

}
