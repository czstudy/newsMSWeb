/**
 * 
 */
package com.newsMS.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.newsMS.dto.Comment;


/**
 * @author Administrator
 *
 */
public interface ICommentDAO {

	/*
	 * 根据newsId获得新闻评论内容。
	 */
	public ArrayList<Comment> getCommentByNewsId(long newsId)throws Exception;
	
	
	
	/*
	 * 设置connection对象。
	 */
	public void setConnetion(Connection conn) throws Exception;
}
