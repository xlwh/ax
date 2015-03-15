/*
 * Title:        爱学圈服务器 2015年1月22日
 * Description:  分页实体bean
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月22日
 */
package com.ax.bean;

import java.util.List;

/**
 * 分页页面实体类对象
 * 封装分页页面的实体bean
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月22日
 */
public class Page<T> {
	/**当前页码**/
	private int currentPage;
	/**上一页**/
	private int lastPage;
	/**下一页**/
	private int nextPage;
	/**是否有下一页**/
	private boolean hasNext;
	/**页面内容**/
	private List<T> rows;
	/**每页显示数目**/
	private int pageSize;
	/**总记录数**/
	private int totalRecard;
	/**页面总数**/
	private int totalPage;
	/**记录起点**/
	private int start;
	/**记录终点**/
	private int max;

	/**
	 * 构造函数
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 */
	public Page() {
		super();
	}
    
	/**
	 * 构造函数
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param currentPage
	 * @param lastPage
	 * @param nextPage
	 * @param hasNext
	 * @param rows
	 * @param pageSize
	 * @param totalRecard
	 * @param totalPage
	 */
	public Page(int currentPage, int lastPage, int nextPage, boolean hasNext, List<T> rows, int pageSize,
			int totalRecard, int totalPage) {
		super();
		this.currentPage = currentPage;
		this.lastPage = lastPage;
		this.nextPage = nextPage;
		this.hasNext = hasNext;
		this.rows = rows;
		this.pageSize = pageSize;
		this.totalRecard = totalRecard;
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecard() {
		return totalRecard;
	}

	public void setTotalRecard(int totalRecard) {
		this.totalRecard = totalRecard;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	

	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", lastPage=" + lastPage + ", nextPage=" + nextPage + ", hasNext="
				+ hasNext + ", rows=" + rows + ", pageSize=" + pageSize + ", totalRecard=" + totalRecard
				+ ", totalPage=" + totalPage + ", start=" + start + ", max=" + max + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentPage;
		result = prime * result + (hasNext ? 1231 : 1237);
		result = prime * result + lastPage;
		result = prime * result + nextPage;
		result = prime * result + pageSize;
		result = prime * result + ((rows == null) ? 0 : rows.hashCode());
		result = prime * result + totalPage;
		result = prime * result + totalRecard;
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page<T> other = (Page<T>) obj;
		if (currentPage != other.currentPage)
			return false;
		if (hasNext != other.hasNext)
			return false;
		if (lastPage != other.lastPage)
			return false;
		if (nextPage != other.nextPage)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (rows == null) {
			if (other.rows != null)
				return false;
		} else if (!rows.equals(other.rows))
			return false;
		if (totalPage != other.totalPage)
			return false;
		if (totalRecard != other.totalRecard)
			return false;
		return true;
	}

}
