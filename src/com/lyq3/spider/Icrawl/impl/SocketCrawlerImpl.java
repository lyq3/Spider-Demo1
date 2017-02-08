package com.lyq3.spider.Icrawl.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import com.lyq3.spider.Icrawl.ICrawler;
import com.lyq3.spider.po.CrawlResult;
import com.lyq3.spider.po.Url;

/**
 * Socket��ʽ����
 * @author Mr.luo
 *
 */
public class SocketCrawlerImpl implements ICrawler{
	CrawlResult crawlResult = new CrawlResult();
	@Override
	public CrawlResult crawl(Url url) {
		if (url == null || url.getUrl() == null) {
			crawlResult.setResult(false);
			crawlResult.setPageContent(null);
			
			return crawlResult;
		}
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			//����Socket����
			Socket socket = new Socket(new URL(url.getUrl()).getHost(), url.getPor());
//			socket.setKeepAlive(false);
			//��ȡ�����
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//�����������HTTP����
			bw.write("GET " + url.getUrl() + " HTTP/1.1\r\n");//\r\n�س�����
			bw.write("HOST:" + url.getUrl() + "\r\n");
			bw.write("\r\n");//ֻ��\r\n��ʾhttp head��������������
			bw.flush();
			
			//��ȡ������
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(br.readLine()).append("\n");
			}
			crawlResult.setResult(true);
			crawlResult.setPageContent(sb.toString());
			return crawlResult;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (br != null) {
					br.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("���ر��쳣");
			}
		}
		return null;
	}
	
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		SocketCrawlerImpl crawlerImpl = new SocketCrawlerImpl();
		CrawlResult crawlResult = crawlerImpl.crawl(new Url("http://www.taobao.com", 80));
		System.out.println(crawlResult.getPageContent());
	}

}
