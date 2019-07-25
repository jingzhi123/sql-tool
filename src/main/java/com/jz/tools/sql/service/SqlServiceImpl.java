package com.jz.tools.sql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jz.tools.sql.entity.CommonItem;
import com.jz.tools.sql.entity.QueryEntity;
import com.jz.tools.sql.mapper.SqlMapper;
import com.jz.tools.util.JsonUtils;
import com.jz.tools.util.PageData;

@Service
public class SqlServiceImpl implements SqlService{

	@Autowired
	private SqlMapper mapper;

	@Override
	public List<PageData> queryAny(String dbName, String tableName, String conditions, String order, String limit) {
		QueryEntity qn = new QueryEntity();
		qn.setDbName(dbName);
		qn.setTableName(tableName);
		Optional.ofNullable(conditions).ifPresent((c)->{
			List<CommonItem> conditionList = JsonUtils.json2List(c, CommonItem.class);
			qn.setConditionList(conditionList);
		});
		Optional.ofNullable(order).ifPresent((o)->{
			CommonItem orderData = JsonUtils.json2Object(o, CommonItem.class);
			qn.setOrderData(orderData);
		});
		Optional.ofNullable(limit).ifPresent((l)->{
			CommonItem limitData = JsonUtils.json2Object(l, CommonItem.class);
			qn.setLimitData(limitData);
		});
		return mapper.queryAny(qn);
	}
	
	public List<PageData> queryAny(String dbName, String tableName, List<CommonItem> conditionList, CommonItem orderData, CommonItem limitData) {
		QueryEntity qn = new QueryEntity();
		qn.setDbName(dbName);
		qn.setTableName(tableName);
		qn.setConditionList(conditionList);
		qn.setOrderData(orderData);
		qn.setLimitData(limitData);
		return mapper.queryAny(qn);
	}

}
