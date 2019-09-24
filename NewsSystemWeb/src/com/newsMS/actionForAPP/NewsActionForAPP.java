package com.newsMS.actionForAPP;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newsMS.dto.News;
import com.newsMS.service.NewsService;
import com.newsMS.util.JsonChangeUtil;

/**
 * Servlet implementation class NewsActionForAPP
 */
public class NewsActionForAPP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out=null;
	 
	NewsService newsService=new NewsService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsActionForAPP() {
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
		
		
		if("listOrderBySendTime".equals(method)){
			 doListOrderBySendTime(request,response);
		}else if("listOrderByCount".equals(method)){
			doListOrderByCount(request,response);
		}else if("show".equals(method)){
			doShowNews(request,response);
			
		}else if("returnNewsJsonStr".equals(method)){
			doReturnNewsJsonStr(request,response);
		}
	}

	private void doReturnNewsJsonStr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		// TODO Auto-generated method stub
		long newsId=0;
		if(request.getParameter("newsId")!=null&&!request.getParameter("newsId").toString().trim().equals("")){
			newsId=Long.parseLong(request.getParameter("newsId").toString().trim());
		}
		//根据newsId去数据库中查找news对象
		News news=null;
		String result="";
		try {
			news=newsService.getNewsByNewsId(newsId);
			
		    result= JsonChangeUtil.jsonFromNewsUseGson(news);
			
			out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doShowNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		long newsId=0;
		if(request.getParameter("newsId")!=null&&!request.getParameter("newsId").toString().trim().equals("")){
			newsId=Long.parseLong(request.getParameter("newsId").toString().trim());
		}
		//根据newsId去数据库中查找news对象
		News news=null;
		try {
			news=newsService.getNewsByNewsId(newsId);
			
			request.setAttribute("news", news);
			//System.out.println("news  test:"+news);
			request.getRequestDispatcher("app/newsDetailPage.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doListOrderByCount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	private void doListOrderBySendTime(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<News> newsList=null;
		String jsonStr="";
		try {
			newsList = newsService.getNewsOrderBySendTimeTop10();
			//jsonStr=JsonChangeUtil.jsonFromList(newsList);
			jsonStr=JsonChangeUtil.jsonFromListUseGson(newsList);
			
			out.println(jsonStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
