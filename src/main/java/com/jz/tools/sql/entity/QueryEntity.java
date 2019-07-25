package com.jz.tools.sql.entity;

import java.util.List;

public class QueryEntity extends BaseEntity{
	private List<CommonItem> conditionList;//查询条件列表
	private CommonItem orderData;//排序数据
	private CommonItem limitData;//限制行数据

	public List<CommonItem> getConditionList() {
		return conditionList;
	}
	public void setConditionList(List<CommonItem> conditionList) {
		this.conditionList = conditionList;
	}
	
	public CommonItem getOrderData() {
		return orderData;
	}
	public void setOrderData(CommonItem orderData) {
		this.orderData = orderData;
	}
	public CommonItem getLimitData() {
		return limitData;
	}
	public void setLimitData(CommonItem limitData) {
		this.limitData = limitData;
	}
	
	
	
}
