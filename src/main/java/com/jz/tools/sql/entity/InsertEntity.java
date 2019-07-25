package com.jz.tools.sql.entity;

import java.util.List;

public class InsertEntity extends BaseEntity{
	private List<CommonItem> dataList;//查询条件列表

	public List<CommonItem> getDataList() {
		return dataList;
	}

	public void setDataList(List<CommonItem> dataList) {
		this.dataList = dataList;
	}

	
	
}
