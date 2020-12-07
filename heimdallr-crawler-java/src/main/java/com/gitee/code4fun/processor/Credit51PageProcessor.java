package com.gitee.code4fun.processor;

import com.gitee.code4fun.pipeline.KafkaPipeline;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public class Credit51PageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        Elements eles = html.getDocument().select("td[class=t_f]");
        eles.forEach(ele -> {
            page.putField(UUID.randomUUID().toString(), ele.text());
        });
        page.addTargetRequests(html.links().all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new Credit51PageProcessor())
                .addUrl("https://bbs.51credit.com")
                .addPipeline(new KafkaPipeline())
                .thread(5)
                .run();
    }

}
