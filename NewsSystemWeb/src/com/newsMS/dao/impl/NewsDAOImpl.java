/**
 * 
 */
package com.newsMS.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.newsMS.dao.INewsDAO;
import com.newsMS.dto.HotNewsCount;
import com.newsMS.dto.News;

/**
 * @author Administrator
 *
 */
public class NewsDAOImpl implements INewsDAO {

	private Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.newsMS.dao.INewsDAO#getNewsOrderBySendTimeTop10()
	 */
	@Override
	public ArrayList<News> getNewsOrderBySendTimeTop10() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<News> newsList = null;
		News news = null;
		try {

			/*
			 * select last_name,first_name,birth,state from president order by
			 * birth limit 5; //只想看前５个 order by birth limit 10,5;
			 * //返回从第11个记录开始的5个记录（跳过了10个）
			 */
			String sql = "select * from news order by sendTime desc limit 0,10";// 如何写sql语句？

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			java.util.Date date = new Date();
			newsList = new ArrayList<News>();
			while (rs.next()) {
				news = new News();
				news.setNewsId(rs.getLong("newsId"));
				news.setTitle(rs.getString("title"));
				// news.setSendTime(rs.getDate("sendTime"));
				// 时间的处理
				// java.util.Date d=new java.util.Date
				// (rs.getDate("sendTime").getTime());
				// System.out.println(d.toString());
				// news.setSendTime(d);
				// rs.getDate("");只能得到日期。

				/*
				 * 当需要把java.util.Date转换成数据库的三种时间类型时，这就不能直接赋值了，这需要使用数据库三种时间类型的构造器
				 * 。java.sql包下的Date、Time、TimeStamp三个类的构造器都需要一个long类型的参数，表示毫秒值（
				 * 时间戳）。创建这三个类型的对象，只需要有毫秒值即可。我们知道java.util.Date有getTime()
				 * 方法可以获取毫秒值（时间戳），那么这个转换也就不是什么问题了。
				 * 
				 * java.utl.Date d = new java.util.Date();
				 * 
				 * java.sql.Date date = new java.sql.Date(d.getTime()); //会丢失时分秒
				 * 
				 * Time time = new Time(d.getTime()); //会丢失年月日
				 * 
				 * Timestamp timestamp = new Timestamp(d.getTime());
				 */
				// java.util.Date d=new java.util.Date();
				//
				// Timestamp timestamp22 = new Timestamp(d.getTime());
				//
				// System.out.println(timestamp22.toLocaleString());

				// 表中时间为日期和时间类型的。要把数据库表中数据拿到应用程序中，就要用这个方法。

				// rs.getDate("ddd");
				Timestamp timestamp = rs.getTimestamp("sendTime");
				if (timestamp != null)
					date = new java.util.Date(timestamp.getTime());

				System.out.println("eeeeeee:" + date.toString());

				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String dateStr = df.format(date);

				Date dateResult = df.parse(dateStr);

				news.setSendTime(dateResult);
				// 一、news表中没有评论个数字段？提示：涉及两张表，新闻表及评论表。最终得到的记录是：newsId,title,sendTime,评论个数。
				// 需要使用复杂点的sql语句来处理，或者使用java代码。
				// System.out.println(rs.getString("title"));
				newsList.add(news);
			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return newsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.newsMS.dao.INewsDAO#setConnetion(java.sql.Connection)
	 */
	@Override
	public void setConnetion(Connection conn) throws Exception {
		// TODO Auto-generated method stub

		this.conn = conn;
	}

	@Override
	public ArrayList<HotNewsCount> getNewsOrderByCounterTop10() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<HotNewsCount> newsList = null;
		HotNewsCount hotNewsCount = null;
		try {

			/*
			 * select last_name,first_name,birth,state from president order by
			 * birth limit 5; //只想看前５个 order by birth limit 10,5;
			 * //返回从第11个记录开始的5个记录（跳过了10个）
			 */
			String sql = "select * from hotnewscountchange limit 0,10";// 如何写sql语句？
			int counter = 0;
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			newsList = new ArrayList<HotNewsCount>();
			while (rs.next()) {
				hotNewsCount = new HotNewsCount();
				hotNewsCount.setNewsId(rs.getLong("newsId"));
				hotNewsCount.setTitle(rs.getString("title"));
				counter = 0;
				if (rs.getInt("counter") != 0) {
					counter = rs.getInt("counter");
				}

				hotNewsCount.setCount(counter);

				// 一、news表中没有评论个数字段？提示：涉及两张表，新闻表及评论表。最终得到的记录是：newsId,title,sendTime,评论个数。
				// 需要使用复杂点的sql语句来处理，或者使用java代码。
				// System.out.println(rs.getString("title"));
				newsList.add(hotNewsCount);
			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return newsList;
	}

	@Override
	public News getNewsByNewsId(long newsId) throws Exception {
		// TODO Auto-generated method stub
		News news = null;
		try {

			/*
			 * select last_name,first_name,birth,state from president order by
			 * birth limit 5; //只想看前５个 order by birth limit 10,5;
			 * //返回从第11个记录开始的5个记录（跳过了10个）
			 */
			String sql = "select * from news where newsId=?";// 如何写sql语句？

			pstm = conn.prepareStatement(sql);
			pstm.setLong(1, newsId);
			rs = pstm.executeQuery();
			if (rs != null) {
				news = new News();
			}

			if (rs.next()) {

				news.setAdminId(rs.getInt("adminId"));
				news.setCategoryId(rs.getInt("categoryId"));
				news.setContent(rs.getString("content"));
				news.setImagePath(rs.getString("imagePath"));
				news.setNewsId(rs.getLong("newsId"));
				news.setSendTime(rs.getDate("sendTime"));
				news.setTitle(rs.getString("title"));
				news.setTitleDesign(rs.getString("titleDesign"));

			}

			rs.close();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return news;
	}

	@Override
	public boolean addNews(News news) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		boolean flag = false;
		try {
			//INSERT INTO tbl_name (col1,col2) VALUES(15,col1*2); 
			String sql = "insert into news(title,titleDesign,content,categoryId,imagePath,sendTime,adminId) values(?,?,?,?,?,?,?)";// 如何写sql语句？

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, news.getTitle());
			pstm.setString(2, news.getTitleDesign());
			pstm.setString(3, news.getContent());
			pstm.setInt(4, news.getCategoryId());
			pstm.setString(5, news.getImagePath());
			java.sql.Date sqlDate=new java.sql.Date(news.getSendTime().getTime());
			
			pstm.setDate(6, sqlDate);
			pstm.setInt(7, news.getAdminId());
			result = pstm.executeUpdate();
			if (result > 0) {
				flag = true;
			}
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

}
