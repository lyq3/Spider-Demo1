package com.lyq3.spider.po;

/**
 * ץȡ����ķ�װʵ����
 * @author Mr.luo
 *
 */
public class CrawlResult {
	/**�ɹ����*/
	private boolean result;
	/**��ҳ����*/
	private String pageContent;
	/**����״̬��*/
	private int httpStatuCode;
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getPageContent() {
		return pageContent;
	}
	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
	}
	public int getHttpStatuCode() {
		return httpStatuCode;
	}
	public void setHttpStatuCode(int httpStatuCode) {
		this.httpStatuCode = httpStatuCode;
	}
	
	
}
