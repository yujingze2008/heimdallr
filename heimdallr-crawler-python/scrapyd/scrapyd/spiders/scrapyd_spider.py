import scrapy

class scrapyd(scrapy.Spider):

    name = "scrapyd"

    start_urls = [
            'http://lab.scrapyd.cn/page/1',
            'http://lab.scrapyd.cn/page/2'
    ]
  
    def parse(self,response):
        page = response.url.split("/")[-2]
        filename = 'scrapyd-%s.html' % page
        with open(filename,'wb') as f :
            f.write(response.body)
        self.log('保存文件：%s' % filename)
