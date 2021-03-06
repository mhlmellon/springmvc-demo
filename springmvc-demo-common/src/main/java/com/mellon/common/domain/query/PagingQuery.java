package com.mellon.common.domain.query;

import java.io.Serializable;

/**
 * The Class of paging query
 *
 * @author mellon
 * @version 1.0
 */
public class PagingQuery implements Serializable {

	/** 缺省页大小 */
	public static final int DEFAULT_PAGE_SIZE = 20;

	/**
	 * 页大小
	 */
	private int pageSize;

	/**
	 * 当前页
	 */
	private int pageIndex;

	public int getPageSize() {
		if (pageSize < 1) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		if (pageIndex < 1) {
			pageIndex = 1;
		}
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

}
