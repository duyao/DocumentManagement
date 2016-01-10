package com.dy.model;

import java.util.List;

public class Pager<T>{
	private List<T> data;
	private int pageOffset;
	private int pageSize;
	private long pageTatal;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getPageTatal() {
		return pageTatal;
	}
	public void setPageTatal(long pageTatal) {
		this.pageTatal = pageTatal;
	}

}
