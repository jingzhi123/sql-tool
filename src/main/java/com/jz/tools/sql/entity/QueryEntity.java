package com.jz.tools.sql.entity;

import java.util.List;

public class QueryEntity extends BaseEntity{
	private String conditions;
	private List<CommonItem> conditionList;//查询条件列表
	private String order;
	private CommonItem orderData;//排序数据
	private String limit;
	private CommonItem limitData;//限制行数据
	
	
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
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
