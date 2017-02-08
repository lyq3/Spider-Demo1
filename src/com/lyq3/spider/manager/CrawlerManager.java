package com.lyq3.spider.manager;

import com.lyq3.spider.Icrawl.ICrawler;
import com.lyq3.spider.Icrawl.impl.SocketCrawlerImpl;
import com.lyq3.spider.po.CrawlResult;
import com.lyq3.spider.po.Url;

/**
 * ����ҵ���߼���ץȡ������
 * @author Mr.luo
 *
 */
public class CrawlerManager {
	private ICrawler crawler;
	
	public CrawlerManager(boolean isSoket) {
		if (isSoket) {//soket����
			this.crawler = new SocketCrawlerImpl();
		}else {//��������
			
		}
	}

	public CrawlerManager(ICrawler crawler) {
		super();
		this.crawler = crawler;
	}

	public CrawlResult crawl(Url url){
		return this.crawler.crawl(url);
	}
}
