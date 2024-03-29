package com.newsMS.dto;

import java.util.Date;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : News.java
//  @ Date : 2017-4-17
//  @ Author : 
//
//




/** */
public class News {
    /** */
    public long NewsId;
    
    /** */
    public String title;
    
    /** */
    public String content;
    
    /** */
    public String imagePath;
    
    /** */
    public int categoryId;
    
    /** */
    public int AdminId;
    
    /** */
    public Date sendTime;
    
    /** */
    public String titleDesign;

	/**
	 * @return the newsId
	 */
	public long getNewsId() {
		return NewsId;
	}

	/**
	 * @param newsId the newsId to set
	 */
	public void setNewsId(long newsId) {
		NewsId = newsId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the adminId
	 */
	public int getAdminId() {
		return AdminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}

	/**
	 * @return the sendTime
	 */
	public Date getSendTime() {
		return sendTime;
	}

	/**
	 * @param sendTime the sendTime to set
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * @return the titleDesign
	 */
	public String getTitleDesign() {
		return titleDesign;
	}

	/**
	 * @param titleDesign the titleDesign to set
	 */
	public void setTitleDesign(String titleDesign) {
		this.titleDesign = titleDesign;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "newsId:"+NewsId+",title:"+title+",content:"+content+",imagePath:"+imagePath+",categoryId:"+categoryId+",AdminId:"+AdminId+",sendTime:"+sendTime;
	}
    
  
}
