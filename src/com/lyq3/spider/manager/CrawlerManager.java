package com.lyq3.spider.manager;

import com.lyq3.spider.Icrawl.ICrawler;
import com.lyq3.spider.Icrawl.impl.HttpUrlConnectionCrawlerImpl;
import com.lyq3.spider.Icrawl.impl.SocketCrawlerImpl;
import com.lyq3.spider.po.CrawlResult;
import com.lyq3.spider.po.Url;

/**
 * 包含业务逻辑的抓取管理器
 * @author Mr.luo
 *
 */
public class CrawlerManager {
	private ICrawler crawler;
	
	public CrawlerManager(boolean isSoket) {
		if (isSoket) {//soket连接
			this.crawler = new SocketCrawlerImpl();
		}else {//其他连接
			this.crawler = new HttpUrlConnectionCrawlerImpl();
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
