package com.jz.tools.sql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jz.tools.sql.entity.CommonItem;
import com.jz.tools.sql.entity.DeleteEntity;
import com.jz.tools.sql.entity.InsertEntity;
import com.jz.tools.sql.entity.QueryEntity;
import com.jz.tools.sql.entity.UpdateEntity;
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

	@Override
	public int deleteAny(String dbName, String tableName, String conditions) {
		DeleteEntity dn = new DeleteEntity();
		dn.setDbName(dbName);
		dn.setTableName(tableName);
		Optional.ofNullable(conditions).ifPresent((c)->{
			List<CommonItem> conditionList = JsonUtils.json2List(c, CommonItem.class);
			dn.setConditionList(conditionList);
		});
		return mapper.deleteAny(dn);
	}

	@Override
	public int insertAny(String dbName, String tableName, String datas) {
		InsertEntity in = new InsertEntity();
		in.setDbName(dbName);
		in.setTableName(tableName);
		Optional.ofNullable(datas).ifPresent((d)->{
			List<CommonItem> dataList = JsonUtils.json2List(d, CommonItem.class);
			in.setDataList(dataList);
		});
		return mapper.insertAny(in);
	}

	@Override
	public int updateAny(String dbName, String tableName, String datas, String conditions) {
		UpdateEntity un = new UpdateEntity();
		un.setDbName(dbName);
		un.setTableName(tableName);
		Optional.ofNullable(datas).ifPresent((d)->{
			List<CommonItem> dataList = JsonUtils.json2List(d, CommonItem.class);
			un.setDataList(dataList);
		});
		Optional.ofNullable(conditions).ifPresent((c)->{
			List<CommonItem> conditionList = JsonUtils.json2List(c, CommonItem.class);
			un.setConditionList(conditionList);
		});
		return mapper.updateAny(un);
	}

}
