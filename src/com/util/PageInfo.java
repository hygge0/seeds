package com.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageInfo {

	List<Object> list=new ArrayList<Object>();//查询结果数据
	
	int currentPage=1;//当前页号
	
	int recordCount=0;//总记录条数
	
	int pageSize=5;//每页记录数
	
	String url=null;//请求的url


	
	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPageCount() {
		//获得总页数
		int count=0;
		if(this.recordCount%this.pageSize==0) {
			count=this.recordCount/this.pageSize;
		}else {
			count=this.recordCount/this.pageSize+1;
		}
		return count;
	}
	
	public PageInfo(HttpServletRequest request) {
		if(request.getParameter("currentPage")!=null) {
			Integer page=Integer.valueOf(request.getParameter("currentPage"));
			this.currentPage=page;
		}
		this.url=request.getRequestURL().toString();
		
		request.setAttribute("pageInfo", this);
	}
	
}
