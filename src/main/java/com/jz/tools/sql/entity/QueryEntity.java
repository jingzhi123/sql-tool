package com.jz.tools.sql.entity;

import java.util.List;

public class QueryEntity {
	private String dbName;
	private String tableName;
	private List<CommonItem> conditionList;
	private CommonItem orderData;
	private CommonItem limitData;
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
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
