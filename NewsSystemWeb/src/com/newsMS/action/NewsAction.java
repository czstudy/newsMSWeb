package com.newsMS.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newsMS.dto.Comment;
import com.newsMS.dto.News;
import com.newsMS.service.CommentService;
import com.newsMS.service.NewsService;

/**
 * Servlet implementation class NewsAction
 */
public class NewsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	NewsService newsService=new NewsService();
	
	CommentService commentService=new CommentService();
	private PrintWriter out=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		out=response.getWriter();
		String method="list";
		if(request.getParameter("method")!=null){
			method=request.getParameter("method").trim();
		}
		
		
		if("list".equals(method)){
			
		}else if("detail".equals(method)){
			doNewsDetail(request,response);
		}else if("add".equals(method)){
			doAdd(request,response);
		}else if("toCreate".equals(method)){
			doCreate(request,response);
		}
	}

	private void doCreate(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			request.getRequestDispatcher("admin/addNews.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doAdd(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag=false;
		String title="",elseTitle="",content="";
		if(request.getParameter("title")!=null&&!request.getParameter("title").toString().trim().equals("")){
			title=request.getParameter("title").toString().trim();
		}
		if(request.getParameter("otherTitle")!=null&&!request.getParameter("otherTitle").toString().trim().equals("")){
			elseTitle=request.getParameter("otherTitle").toString().trim();
		}
		if(request.getParameter("descipt")!=null&&!request.getParameter("descipt").toString().trim().equals("")){
			content=request.getParameter("descipt").toString().trim();
		}
		
		
		News news=new News();
		news.setTitle(title);
		news.setTitleDesign(elseTitle);
		news.setContent(content);
		news.setAdminId(1);
		news.setCategoryId(4);
		news.setImagePath("");
		news.setSendTime(new Date());
		
		try {
			flag=newsService.addNews(news);
			if(flag){
				request.setAttribute("info", "添加成功");
			}else{
				request.setAttribute("info", "添加错误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("title:"+title+"/ncontent:"+content);
		request.getRequestDispatcher("admin/addNews.jsp").forward(request, response);
	}

	private void doNewsDetail(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException {
		// TODO Auto-generated method stub
		//缺少从数据库中读取具体某条新闻
		long newsId=0;
		
		
		ArrayList<Comment> commentList=null;
		if(request.getParameter("newsId")!=null&&!request.getParameter("newsId").toString().trim().equals("")){
			newsId=Long.parseLong(request.getParameter("newsId").toString().trim());
		}
		//根据newsId去数据库中查找news对象
		News news=null;
		try {
			news=newsService.getNewsByNewsId(newsId);
			
			
			
			
			
			commentList=commentService.getCommentByNewsId(newsId);
			
			
			request.setAttribute("news", news);
			//System.out.println("news  test:"+news);
			
			
			//读出该条新闻的所有评论comentList
			//根据该新闻的Id号，到数据库中读取有关该条新闻的所有评论，并且评论是按时间的降序排列
			
			for(int i=0;i<commentList.size();i++){
				System.out.println("评论的内容："+commentList.get(i).getContent());
			}
			
			request.setAttribute("commentList", commentList);			
			
			request.getRequestDispatcher("page/newsDetailPage.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
