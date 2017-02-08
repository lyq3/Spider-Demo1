package com.lyq3.spider.Icrawl;

import com.lyq3.spider.po.CrawlResult;
import com.lyq3.spider.po.Url;

public interface ICrawler {
	public CrawlResult crawl(Url url);
}
