package com.newsMS.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommentAction
 */
public class CommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PrintWriter out=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html;charset=utf-8");
		out=response.getWriter();
		String method="list";
		System.out.println("dopost");
		if(request.getParameter("method")!=null){
			method=request.getParameter("method").trim();
		}
		if(request.getParameter("ddd")!=null){
			String ddd=request.getParameter("ddd").trim();
			System.out.println(ddd);
		}
		
		System.out.println(method);
		if("list".equals(method)){
			
		}else if("toSender".equals(method)){
			doToSender(request,response);
		}else if("add".equals(method)){
			doAdd(request,response);
		}else if("toCreate".equals(method)){
			
		}
	}

	private void doAdd(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	private void doToSender(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddddd");
		if(request.getSession().getAttribute("userId")==null||request.getSession().getAttribute("userId").toString().trim().equals("")){
			response.sendRedirect("page/loginPage.jsp");
		}
	}

}
