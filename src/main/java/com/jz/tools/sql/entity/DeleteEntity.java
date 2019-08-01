package com.jz.tools.sql.entity;

import java.util.List;

public class DeleteEntity extends BaseEntity {
	private String conditions;// 查询条件
	private List<CommonItem> conditionList;// 查询条件列表
	
	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public List<CommonItem> getConditionList() {
		return conditionList;
	}

	public void setConditionList(List<CommonItem> conditionList) {
		this.conditionList = conditionList;
	}

}
