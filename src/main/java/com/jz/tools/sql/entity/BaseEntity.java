package com.jz.tools.sql.entity;

import javax.validation.constraints.NotEmpty;

public class BaseEntity {

	private String dbName;
	@NotEmpty(message = "tableName(表名)不能为空!")
	private String tableName;
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
	

}
