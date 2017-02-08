package com.lyq3.spider.Icrawl.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.lyq3.spider.Icrawl.ICrawler;
import com.lyq3.spider.po.CrawlResult;
import com.lyq3.spider.po.Url;

/**
 * HttpUrlConnection方式连接
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
		//获取连接
		HttpURLConnection httpURLConnection = url.getConnection();
		BufferedReader br = null;
		if (httpURLConnection != null) {
			try {
				//获取读入流
				br = new BufferedReader(
						new InputStreamReader(
								httpURLConnection.getInputStream(), "UTF-8"));
				String line = null;
				StringBuffer sb = new StringBuffer();
				//读取数据
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
						System.out.println("流关闭异常");
					}
				}
			}
			return crawlResult;
			
		}
		return null;
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		HttpUrlConnectionCrawlerImpl hcc = new HttpUrlConnectionCrawlerImpl();
		CrawlResult crawlResult = hcc.crawl(new Url("http://www.baidu.com", 80));
		System.out.println(crawlResult.getPageContent());
	}
}
