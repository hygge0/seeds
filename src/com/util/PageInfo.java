package com.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageInfo {

	List<Object> list=new ArrayList<Object>();//��ѯ�������
	
	int currentPage=1;//��ǰҳ��
	
	int recordCount=0;//�ܼ�¼����
	
	int pageSize=5;//ÿҳ��¼��
	
	String url=null;//�����url


	
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
		//�����ҳ��
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
