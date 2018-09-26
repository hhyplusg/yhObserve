package com.wave.core.pagination;


/**
 * 分页bean 
 */
public class PageBean {
	 /** 
	  * 每页显示记录数  
	  * */
	public static final int NUMBERS_PER_PAGE = 10;

	/** 
	 * 一页显示的记录数
	 */ 
	public int numPerPage;

	/**
	 * 记录总数
	 * */ 
	public int totalRows;

	/**
	 *  总页数
	 * */
	public int totalPages;

	/**
	 * 当前页码
	 * */ 
	public int currentPage;

	/**
	 * 起始行数
	 * */ 
	public int startIndex;

	/**
	 * 结束行数
	 * */ 
	public int lastIndex;
 
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	// 计算总页数
	public void setTotalPages() {
		if (totalRows % numPerPage == 0) {
			this.totalPages = totalRows / numPerPage;
		} else {
			this.totalPages = (totalRows / numPerPage) + 1;
		}
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex() {
		this.startIndex = (currentPage - 1) * numPerPage;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	// 计算结束时候的索引
	public void setLastIndex() {
		if (totalRows < numPerPage) {
			this.lastIndex = totalRows;
		} else if ((totalRows % numPerPage == 0)|| (totalRows % numPerPage != 0 && currentPage < totalPages)) {
			this.lastIndex = currentPage * numPerPage;
		} else if (totalRows % numPerPage != 0 && currentPage == totalPages) {// 最后一页
			this.lastIndex = totalRows;
		}
	}
}
