package com.lyq3.spider.control;

import java.util.ArrayList;
import java.util.List;

import com.lyq3.spider.manager.CrawlerManager;
import com.lyq3.spider.po.CrawlResult;
import com.lyq3.spider.po.Url;

/**
 * ϵͳ������
 * @author Mr.luo
 *
 */
public class SystemController {
	/**
	 * ��ʵ�ֲ���һ��
	 * @param args
	 */
	public static void main(String[] args) {
		List<Url> list = new ArrayList<Url>();
		list.add(new Url("http://www.baidu.com", 80));
		list.add(new Url("http://www.qq.com", 80));
		
		//ʵ��������������httpURLConnection��ʽ��ȡ
		CrawlerManager crawlerManager = new CrawlerManager(false);
		
		for (Url url : list) {
			CrawlResult crawlResult = crawlerManager.crawl(url); 
			System.out.println(crawlResult.getPageContent());
		}
	}
}
