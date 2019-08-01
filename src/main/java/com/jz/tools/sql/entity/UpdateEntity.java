package com.jz.tools.sql.entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UpdateEntity extends BaseEntity {
	private List<CommonItem> dataList;// 数据列表
	@NotEmpty(message = "datas不能为空!")
	@Pattern(regexp = "\\[\\{.+\\}\\]",message = "datas数组中必须有数据")
	private String datas;
	private List<CommonItem> conditionList;// 查询条件列表
	private String conditions;
	

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getDatas() {
		return datas;
	}

	public void setDatas(String datas) {
		this.datas = datas;
	}

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
