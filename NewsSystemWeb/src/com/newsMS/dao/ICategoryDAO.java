/**
 * 
 */
package com.newsMS.dao;

import com.newsMS.dto.Category;

/**
 * @author Administrator
 *
 */
public interface ICategoryDAO {

	/**
	 *@author Administrator
     * add
	 */
	
     public  int addCategory(Category category) throws Exception;
     
     /**
 	 *@author Administrator
      * delete
 	 */
 	
      public  int deleteCategory(int  categoryId) throws Exception;
      
      /**
  	 *@author Administrator
       * update
  	 */
  	
       public  int updateCategory(Category category) throws Exception;
       
       
       /**
   	 *@author Administrator
        * searchCateogyById
   	 */
   	
        public  Category searchCategoryById(int categoryId) throws Exception;
        
        
        /**
       	 *@author Administrator
            * searchCateogyByCategoryName
       	 */
       	
            public  Category searchCateogyByCategoryName(String categoryName) throws Exception;
}
