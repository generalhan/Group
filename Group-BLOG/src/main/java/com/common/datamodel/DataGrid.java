package com.common.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * easy ui������װ��
 * @author zwl
 *
 */
public class DataGrid {

	private Long total = 0l;                   //�ܼ�¼
	private List rows = new ArrayList();       //datagrid��Ҫ��json���ݼ�������

	
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
