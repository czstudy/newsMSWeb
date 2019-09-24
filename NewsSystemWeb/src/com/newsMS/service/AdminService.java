package com.newsMS.service;

import java.sql.Connection;

import javax.servlet.jsp.tagext.TryCatchFinally;

import com.newsMS.dao.IAdminDAO;
import com.newsMS.dao.impl.AdminDAOImpl;
import com.newsMS.db.DataBase;
import com.newsMS.dto.Admin;

public class AdminService {

	private Connection conn=null;
	private IAdminDAO adminDaoImpl=new AdminDAOImpl();
	
	public Admin login(Admin admin) throws Exception{
		
		Admin adminResult=null;
		try{
			conn=DataBase.getConn();
			adminDaoImpl.setConnetion(conn);
			adminResult=adminDaoImpl.login(admin);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return adminResult;
	}
}
