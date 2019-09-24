/**
 * 
 */
package com.newsMS.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.newsMS.dao.IAdminDAO;
import com.newsMS.dto.Admin;

/**
 * @author Administrator
 *
 */
public class AdminDAOImpl implements IAdminDAO {

	/**
	 * 
	 */
	
	private Connection conn=null;
	private PreparedStatement pstm=null;
	private ResultSet rs=null;
	
	
	public AdminDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.newsMS.dao.IAdminDAO#login(com.newsMS.dto.Admin)
	 */
	@Override
	public Admin login(Admin admin) throws Exception {
		// TODO Auto-generated method stub
	     String sql="select * from admin where loginName=? and password=?";
		
	     Admin adminResult=null;
	     pstm=conn.prepareStatement(sql);
	     pstm.setString(1, admin.getLoginName());
	     pstm.setString(2, admin.getPassword());
	     
	     rs=pstm.executeQuery();
	     if(rs.next()){
	    	 adminResult=new Admin();
	    	 adminResult.setAdminId(rs.getInt("adminId"));
	    	 adminResult.setLoginName(rs.getString("loginName"));
	    	 adminResult.setRealName(rs.getString("realName"));
	     }
		
		return adminResult;
	}

	@Override
	public void setConnetion(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		this.conn=conn;
	}

}
