/**
 * 
 */
package com.newsMS.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.newsMS.dto.HotNewsCount;
import com.newsMS.dto.News;

/**
 * @author Administrator
 *
 */
public interface INewsDAO {

	/*
	 * 获得最新的10条新闻，按发布新闻的顺序，后发的在上。
	 */
	public ArrayList<News> getNewsOrderBySendTimeTop10()throws Exception;
	
	
	/*
	 * 获得最热的10条新闻，按发布新闻的顺序，后发的在上。
	 */
	public ArrayList<HotNewsCount> getNewsOrderByCounterTop10()throws Exception;
	
	
	/*
	 * 根据newsId获得新闻内容。
	 */
	public News getNewsByNewsId(long newsId)throws Exception;
	
	
	/*
	 * 添加新闻。
	 */
	public boolean addNews(News news)throws Exception;
	
	/*
	 * 设置connection对象。
	 */
	public void setConnetion(Connection conn) throws Exception;
}
