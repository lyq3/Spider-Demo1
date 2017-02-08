package com.lyq3.spider.po;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.lyq3.spider.enumeration.TaskLevel;

/**
 * URL实体类
 * @author Mr.luo
 *
 */
public class Url {
	/**地址*/
	private String url;
	/**端口*/
	private int por;
	/**优先级*/
	private TaskLevel level = TaskLevel.MIDDLE;
	
	public Url(String url){
		this.url = url;
	}
	public Url(String url, TaskLevel level){
		this.url = url;
		this.level = level;
	}
	public Url(String url, int por){
		this.url = url;
		this.por = por;
	}
	public Url(String url, int por, TaskLevel level){
		this.url = url;
		this.por = por;
		this.level = level;
	}
	/**
	 * 获取HttpURLConnection
	 * @return
	 */
	public HttpURLConnection getConnection(){
		try {
			URL sysURL = new URL(this.url);
			URLConnection connection = sysURL.openConnection();
			if(connection instanceof HttpURLConnection){
				return (HttpURLConnection) connection;
			} else {
				throw new Exception("创建连接异常");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public TaskLevel getLevel() {
		return level;
	}
	public void setLevel(TaskLevel level) {
		this.level = level;
	}
	public int getPor() {
		return por;
	}
	public void setPor(int por) {
		this.por = por;
	}
	
	
}
