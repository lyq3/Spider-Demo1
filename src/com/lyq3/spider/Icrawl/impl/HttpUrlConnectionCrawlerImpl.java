package com.lyq3.spider.Icrawl.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.lyq3.spider.Icrawl.ICrawler;
import com.lyq3.spider.po.CrawlResult;
import com.lyq3.spider.po.Url;

/**
 * HttpUrlConnection��ʽ����
 * @author Mr.luo
 *
 */
public class HttpUrlConnectionCrawlerImpl implements ICrawler{
	CrawlResult crawlResult = new CrawlResult();
	@Override
	public CrawlResult crawl(Url url) {
		if (url == null || url.getUrl() == null) {
			crawlResult.setResult(false);
			crawlResult.setPageContent(null);
			
			return crawlResult;
		}
		//��ȡ����
		HttpURLConnection httpURLConnection = url.getConnection();
		BufferedReader br = null;
		if (httpURLConnection != null) {
			try {
				//��ȡ������
				br = new BufferedReader(
						new InputStreamReader(
								httpURLConnection.getInputStream(), "UTF-8"));
				String line = null;
				StringBuffer sb = new StringBuffer();
				//��ȡ����
				while ((line = br.readLine()) != null) {
					sb.append(br.readLine()).append("\n");
				}
				crawlResult.setResult(true);
				crawlResult.setPageContent(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("���ر��쳣");
					}
				}
			}
			return crawlResult;
			
		}
		return null;
	}

	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		HttpUrlConnectionCrawlerImpl hcc = new HttpUrlConnectionCrawlerImpl();
		CrawlResult crawlResult = hcc.crawl(new Url("http://www.baidu.com", 80));
		System.out.println(crawlResult.getPageContent());
	}
}
