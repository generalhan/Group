package com.common.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * easy ui交互包装类
 * @author zwl
 *
 */
public class DataGrid {

	private Long total = 0l;                   //总记录
	private List rows = new ArrayList();       //datagrid需要的json数据加载数据

	
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}
