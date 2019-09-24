/**
 * 
 */
package com.newsMS.dao.impl;

import com.newsMS.dao.ICategoryDAO;
import com.newsMS.dto.Category;

/**
 * @author Administrator
 *
 */
public class CategoryDAOImpl implements ICategoryDAO {

	/**
	 * 
	 */
	public CategoryDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.newsMS.dao.ICategoryDAO#addCategory(com.newsMS.dto.Category)
	 */
	@Override
	public int addCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.newsMS.dao.ICategoryDAO#deleteCategory(int)
	 */
	@Override
	public int deleteCategory(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.newsMS.dao.ICategoryDAO#updateCategory(com.newsMS.dto.Category)
	 */
	@Override
	public int updateCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.newsMS.dao.ICategoryDAO#searchCategoryById(int)
	 */
	@Override
	public Category searchCategoryById(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.newsMS.dao.ICategoryDAO#searchCateogyByCategoryName(java.lang.String)
	 */
	@Override
	public Category searchCateogyByCategoryName(String categoryName)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
