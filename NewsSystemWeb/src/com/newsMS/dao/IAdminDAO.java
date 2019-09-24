/**
 * 
 */
package com.newsMS.dao;

import java.sql.Connection;

import com.newsMS.dto.Admin;

/**
 * @author Administrator
 *
 */
public interface IAdminDAO {

	/*
	 * @function:
	 * @author:
	 * 
	 */
	public Admin login(Admin admin) throws Exception;
	
	
	
	/*
	 * @function:
	 * @author:
	 * 
	 */
	public void setConnetion(Connection conn) throws Exception;
}
