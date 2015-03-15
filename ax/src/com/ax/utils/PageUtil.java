/*
 * Title:        爱学圈服务器 2015年1月22日
 * Description:  分页工具
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月22日
 */
package com.ax.utils;

import com.ax.bean.Page;
import com.ax.exception.ExceptionHandle;
import com.ax.exception.MethodParamException;
import com.ax.exception.NullPointException;

/**
 * 分页工具
 * 完成分页的辅助操作工具
 * （1）新页面，传入页面显示记录数目，总记录数，计算出总页数，设置上一页为-1（不可翻）
 *     
 *     计算是不是有第二页（totalRecard>=pageSize）,返回Page对象
 *     
 * （2）翻页页面，传入上一个页面（上页：-1 下一页：本页 ）
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月22日
 */
public class PageUtil <T>{
	
	/**
	 * 
	 * 从第一页开始翻页
	 * 当进入初始页面的时候创建一个新的页面
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param pageSize   每页记录数
	 * @param totalRecard   总记录数
	 * @return              page
	 */
	public  Page<T> newPage(int pageSize,int totalRecard){
		Page<T> page = new Page<T>();
		if(pageSize<0 || totalRecard<0){
			MethodParamException e = new MethodParamException("传入的页面参数不能为：pageSize="+pageSize+",totalRecard="+totalRecard);
			ExceptionHandle.throwException(e, "com.ax.utils.PageUtil#newPage(int pageSize,int totalRecard)");
		}else{
			page.setLastPage(-1);
			page.setCurrentPage(1);
			page.setPageSize(pageSize);
			page.setStart(0);
			page.setMax(pageSize);
			boolean hasNext = hasNext(pageSize,totalRecard);
			page.setHasNext(hasNext);
			if(hasNext == true){
				page.setNextPage(2);
			}else{
				page.setNextPage(-1);
			}
			page.setTotalPage(getTotalPage(pageSize,totalRecard));
			page.setTotalRecard(totalRecard);
		}
		return page;
	}
	
	
	/**
	 * 计算是不是有第二页
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param pageSize
	 * @param totalRecard
	 * @return
	 */
	public boolean hasNext(int pageSize,int totalRecard){
		/*下一页要显示的记录pageSize,记录数目1--->pagesize
		  total = n*size  has=total-current*size
	      if(has>size)---->	has  else--->no  
        */
		int has = totalRecard-pageSize;
		if(has>0){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * 
	 * (一句话功能简述)
	 * 是不是有下一页，针对第二页以后的页面
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param page
	 * @return
	 */
	public boolean hasNext(Page<T> page){
		if(page == null){
			NullPointException e = new NullPointException("page对象不可为空！");
			ExceptionHandle.throwException(e, "com.ax.utils.PageUtil#hasNext(Page<T> page)");
		}
		int currentPage = page.getCurrentPage();
		int pageSize = page.getPageSize();
	    int has = page.getTotalRecard()-currentPage*pageSize;
		if(has>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * 计算总页面数目
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param pageSize
	 * @param totalRecard
	 * @return
	 */
	public int getTotalPage(int pageSize,int totalRecard){
		int num = 0;
		if(pageSize<=0 || totalRecard <=0){
			MethodParamException e = new MethodParamException("传入的页面参数不能为：pageSize="+pageSize+",totalRecard="+totalRecard);
			ExceptionHandle.throwException(e, "com.ax.utils#getTotalPage(int pageSize,int totalRecard)");
		}else{
			num = totalRecard/pageSize;
		}
		return num;
	}
	/**
	 * 
	 * 上一页
	 * 翻页翻到上一页，如果存在上一页，则返回上一页的页面对象
	 * 否则返回空
	 * 算法：
	 *   （1）计算判断是不是有上一页
	 *   （2）如果有上一页则设定currentPage = currentPage-1
	 *                   hasNext = true
	 *                   max = currentPage*pageSize
	 *                   start = currentPage*pageSize-pageSize
	 *                   nextPage = currentPage+1
	 *                   pageSize = PageSize;
	 *                   totalPage = totalPage
	 *                   totalRecard = totalRecard 
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param page
	 * @return
	 */
	public Page<T> lastPage(Page<T> page){
	   if(page.getLastPage() == -1){
		   return null;    //没有上一页
	   }else{
		   int currentPage = page.getLastPage();
		   boolean hasNext = true;
		   int max = currentPage*page.getPageSize();
		   int pageSize = page.getPageSize();
		   int start = currentPage*pageSize-pageSize;
		   int nextPage = page.getCurrentPage();
		    page.setCurrentPage(currentPage);
		    page.setHasNext(hasNext);
		    page.setMax(max);
		    page.setPageSize(pageSize);
		    page.setStart(start);
		    page.setNextPage(nextPage);
		   return page;
	   }
		
	}
	
	/**
	 * 
	 * 
	 * 下一页
	 *   （1）计算判断是不是有上一页
	 *   （2）如果有上一页则设定currentPage = currentPage+1 || currentPage = nextPage
	 *                   hasNext = true  (计算)
	 *                   max = currentPage*pageSize 
	 *                   start = currentPage*pageSize-pageSize
	 *                   if hasNext==true---->nextPage = currentPage+1  else nextPage=-1
	 *                   pageSize = PageSize;
	 *                   totalPage = totalPage
	 *                   totalRecard = totalRecard  
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param nextPage
	 * @return
	 */
	public Page<T> nextPage(Page<T> page){
		if(page.isHasNext()==true){
			int currentPage = page.getNextPage();
			boolean hasNext = hasNext(page);
			int pageSize = page.getPageSize();
			int max = currentPage*pageSize;
			int start = currentPage*pageSize-pageSize;
			page.setCurrentPage(currentPage);
			page.setHasNext(hasNext);
			page.setMax(max);
			page.setStart(start);
			return page;
		}else{
			return null;
		}
		
	}
	
}
