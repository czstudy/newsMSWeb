/**
 * 
 */
package com.newsMS.dto;

/**
 * @author Administrator
 *
 */
public class HotNewsCount {

	private long newsId;
	private String title;
	private int count;
	public long getNewsId() {
		return newsId;
	}
	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
