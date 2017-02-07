package com.lyq3.spider.po;

import com.lyq3.spider.enumeration.TaskLevel;

/**
 * URLʵ����
 * @author Mr.luo
 *
 */
public class Url {
	/**��ַ*/
	private String url;
	/**���ȼ�*/
	private TaskLevel level = TaskLevel.MIDDLE;
	
	public Url(String url){
		this.url = url;
	}
	public Url(String url, TaskLevel level){
		this.url = url;
		this.level = level;
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
	
	
}
