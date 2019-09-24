package com.newsMS.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newsMS.dto.Admin;
import com.newsMS.service.AdminService;
import com.newsMS.util.MD5Util;

/**
 * Servlet implementation class AdminAction
 */
public class AdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter out=null;
	
	AdminService adminService=new AdminService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAction() {
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
		String method="login";
		if(request.getParameter("method")!=null){
			method=request.getParameter("method").trim();
		}
		
		
		if("login".equals(method)){
			doLogin(request,response);
		}else if("add".equals(method)){
			
		}else{
			
		}
	}

	private void doLogin(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginName="";
		String password="";
		Admin admin=new Admin();
		Admin adminResult=null;
		if(request.getParameter("loginName")!=null&&request.getParameter("loginName").trim()!=""){
			loginName=request.getParameter("loginName").trim();
		}
		
		if(request.getParameter("password")!=null&&request.getParameter("password").trim()!=""){
			password=request.getParameter("password").trim();
		}
		
		admin.setLoginName(loginName);
		//admin.setPassword(password);
		
		
		try {
			admin.setPassword(MD5Util.EncoderByMd5(password));
			
			
			adminResult=adminService.login(admin);
			if(adminResult!=null){
				System.out.println("测试管理员登录："+adminResult.getRealName());
				//request.setAttribute("admin", adminResult);
				request.getSession().setAttribute("realName", adminResult.getRealName());
				//response.sendRedirect("admin/adminIndex.jsp");
				request.getRequestDispatcher("admin/adminIndex.jsp").forward(request, response);
			}else{
				response.sendRedirect("admin/login.jsp");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
