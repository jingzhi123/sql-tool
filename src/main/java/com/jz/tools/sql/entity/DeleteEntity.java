package com.jz.tools.sql.entity;

import java.util.List;

public class DeleteEntity extends BaseEntity {
	private List<CommonItem> conditionList;// 查询条件列表

	public List<CommonItem> getConditionList() {
		return conditionList;
	}

	public void setConditionList(List<CommonItem> conditionList) {
		this.conditionList = conditionList;
	}

}
