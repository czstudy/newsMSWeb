/**
 * 
 */
package com.newsMS.service;

import java.sql.Connection;
import java.util.ArrayList;


import com.newsMS.dao.INewsDAO;

import com.newsMS.dao.impl.NewsDAOImpl;
import com.newsMS.db.DataBase;

import com.newsMS.dto.HotNewsCount;
import com.newsMS.dto.News;

/**
 * @author Administrator
 *
 */
public class NewsService {

	
	private INewsDAO newsDaoImpl=new NewsDAOImpl() ;
	
	public ArrayList<News> getNewsOrderBySendTimeTop10() throws Exception {
		ArrayList<News> newsList=null;
		Connection conn=null;
		try{
			conn=DataBase.getConn();
			newsDaoImpl.setConnetion(conn);
			newsList=newsDaoImpl.getNewsOrderBySendTimeTop10();
			
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return newsList;
	}
	
	
	public ArrayList<HotNewsCount> getNewsOrderByCounterTop10() throws Exception{
		
		ArrayList<HotNewsCount> newsList=null;
		 Connection conn=null;
		try{
			conn=DataBase.getConn();
			newsDaoImpl.setConnetion(conn);
			newsList=newsDaoImpl.getNewsOrderByCounterTop10();
			
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return newsList;
	}
	
	
	public News getNewsByNewsId(long newsId)throws Exception{
		
		News news=null;
		 Connection conn=null;
		try{
			conn=DataBase.getConn();
			newsDaoImpl.setConnetion(conn);
			news=newsDaoImpl.getNewsByNewsId(newsId);
			
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return news;
	}
	
	public boolean addNews(News news) throws Exception {
		
	    Connection conn=null;
	    boolean flag=false;
		try{
			conn=DataBase.getConn();
			newsDaoImpl.setConnetion(conn);
			flag=newsDaoImpl.addNews(news);
			conn.commit();			
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
}
