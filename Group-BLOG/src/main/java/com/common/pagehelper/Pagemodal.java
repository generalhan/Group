package com.common.pagehelper;

import java.util.List;

public class Pagemodal {
	
    /**���������ҳ�Ķ�̬����**/
     private List<?> list;   
     private Page page;
     
     
public List<?> getList() {
	return list;
}
public Page getPage() {
	return page;
}
public void setList(List<?> clazz) {
	this.list = clazz;
}
public void setPage(Page page) {
	this.page = page;
}
}
