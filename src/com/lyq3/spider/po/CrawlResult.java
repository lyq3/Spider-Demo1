package com.lyq3.spider.po;

/**
 * 抓取结果的封装实体类
 * @author Mr.luo
 *
 */
public class CrawlResult {
	/**成功与否*/
	private boolean result;
	/**网页内容*/
	private String pageContent;
	/**请求状态码*/
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
