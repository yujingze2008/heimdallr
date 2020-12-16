import scrapy

class chyxxSpider(scrapy.Spider):

    name = "chyxxSpider"

    start_urls = [
            'https://www.chyxx.com/data/'
    ]

    def parse(self,response):
        #print(">>>>>>>>>>>>>>>>:" + response.css('title').extract_first())
        item = {'title':response.css('title').extract_first()}
        yield item
        # page = response.url.split("/")[-2]
        # filename = 'scrapyd-%s.html' % page
        # with open(filename,'wb') as f :
        #     f.write(response.body)
        # self.log('保存文件：%s' % filename)
        next_pages = response.css('a::attr(href)').extract()
        counts = 0

        for my_link in next_pages : 
            #print(my_link)
            if(my_link.find('javascript') != -1):
                continue
            if(my_link.find('chyxx') != -1):
                continue
            #counts += 1
            if(my_link != response.url):
                if(my_link != ''):
                    my_link = response.urljoin(my_link)
                    yield scrapy.Request(my_link, callback=self.parse)
        #print("$$$$$"+str(counts))
         