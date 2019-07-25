package com.jz.tools.sql.entity;

import java.util.List;

public class UpdateEntity extends BaseEntity {
	private List<CommonItem> dataList;// 数据列表
	private List<CommonItem> conditionList;// 查询条件列表

	public List<CommonItem> getDataList() {
		return dataList;
	}

	public void setDataList(List<CommonItem> dataList) {
		this.dataList = dataList;
	}

	public List<CommonItem> getConditionList() {
		return conditionList;
	}

	public void setConditionList(List<CommonItem> conditionList) {
		this.conditionList = conditionList;
	}

}
