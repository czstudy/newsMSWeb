package com.newsMS.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newsMS.dto.HotNewsCount;
import com.newsMS.dto.News;
import com.newsMS.service.NewsService;
import com.newsMS.util.MD5Util;

/**
 * Servlet implementation class WelcomeAction
 */
public class WelcomeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	NewsService newsService=new NewsService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeAction() {
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
		ArrayList<News> newsList=null;
		ArrayList<HotNewsCount> hotNewsList=null;
		try {
			newsList=newsService.getNewsOrderBySendTimeTop10();
			hotNewsList=newsService.getNewsOrderByCounterTop10();
			
			//begin测试一下Md5
			
			    String makeMd5String=MD5Util.EncoderByMd5("abc");
			    System.out.println("abc   的Md5值:"+makeMd5String);
//			    boolean result=MD5Util.checkpassword("abc", makeMd5String);
//			    System.out.println("验证结果："+result);
//			
			//end
			
			
			
			
			request.setAttribute("hotNewsList", hotNewsList);
			request.setAttribute("newsList", newsList);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
