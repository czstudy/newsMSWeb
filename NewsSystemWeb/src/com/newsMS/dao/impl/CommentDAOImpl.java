/**
 * 
 */
package com.newsMS.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.newsMS.dao.ICommentDAO;
import com.newsMS.dto.Comment;
import com.newsMS.dto.News;

/**
 * @author Administrator
 *
 */
public class CommentDAOImpl implements ICommentDAO {

	
	private Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	/* (non-Javadoc)
	 * @see com.newsMS.dao.ICommentDAO#getCommentByNewsId(long)
	 */
	@Override
	public ArrayList<Comment> getCommentByNewsId(long newsId) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<Comment> commentList=null;
		Comment comment=null;
		
		try {

		
			String sql = "select * from comment where newsId=? order by sendtime desc";// 如何写sql语句？

			pstm = conn.prepareStatement(sql);
			pstm.setLong(1, newsId);
			rs = pstm.executeQuery();
			if (rs != null) {
				commentList=new ArrayList<Comment>();
			}

			while (rs.next()) {

				comment=new Comment();
				comment.setCommentId(rs.getLong("commentId"));
				comment.setContent(rs.getString("content"));
				comment.setNewsId(rs.getLong("newsId"));
				comment.setUserId(rs.getLong("userId"));
				comment.setSendTime(rs.getDate("sendTime"));
			

				commentList.add(comment);
				
			}

			rs.close();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		return commentList;
	}

	/* (non-Javadoc)
	 * @see com.newsMS.dao.ICommentDAO#setConnetion(java.sql.Connection)
	 */
	@Override
	public void setConnetion(Connection conn) throws Exception {
		// TODO Auto-generated method stub

		this.conn=conn;
	}

}
