package com.newsMS.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.newsMS.dao.ICommentDAO;
import com.newsMS.dao.impl.CommentDAOImpl;
import com.newsMS.db.DataBase;
import com.newsMS.dto.Comment;
import com.newsMS.dto.News;

public class CommentService {

	private ICommentDAO commentDAOImpl=new CommentDAOImpl();
	
public ArrayList<Comment> getCommentByNewsId(long newsId)throws Exception{
		
	ArrayList<Comment> commentList=null;
		 Connection conn=null;
		try{
			conn=DataBase.getConn();
			commentDAOImpl.setConnetion(conn);
			commentList=commentDAOImpl.getCommentByNewsId(newsId);
			
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return commentList;
	}
}
