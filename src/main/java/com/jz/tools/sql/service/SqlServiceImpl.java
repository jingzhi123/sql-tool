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
	public List<PageData> querySql(String sql) {
		// TODO Auto-generated method stub
		return mapper.querySql(sql);
	}

	@Override
	public List<PageData> queryAny(QueryEntity qn) {
		Optional.ofNullable(qn.getConditions()).ifPresent((c)->{
			List<CommonItem> conditionList = JsonUtils.json2List(c, CommonItem.class);
			if(!conditionList.isEmpty()){
				qn.setConditionList(conditionList);
			}
		});
		Optional.ofNullable(qn.getOrder()).ifPresent((o)->{
			CommonItem orderData = JsonUtils.json2Object(o, CommonItem.class);
			qn.setOrderData(orderData);
		});
		Optional.ofNullable(qn.getLimit()).ifPresent((l)->{
			CommonItem limitData = JsonUtils.json2Object(l, CommonItem.class);
			qn.setLimitData(limitData);
		});
		
		return mapper.queryAny(qn);
	}
	
	@Override
	public int deleteAny(DeleteEntity dn) {
		
		Optional.ofNullable(dn.getConditions()).ifPresent((c)->{
			List<CommonItem> conditionList = JsonUtils.json2List(c, CommonItem.class);
			if(!conditionList.isEmpty()){
				dn.setConditionList(conditionList);
			}
		});
		return mapper.deleteAny(dn);
	}


	@Override
	public int insertAny(InsertEntity in) {
		Optional.ofNullable(in.getDatas()).ifPresent((d)->{
			List<CommonItem> dataList = JsonUtils.json2List(d, CommonItem.class);
			if(dataList.isEmpty()){
				throw new RuntimeException("dataList必须有数据!");
			}
			in.setDataList(dataList);
		});
		return mapper.insertAny(in);
	}

	@Override
	public int updateAny(UpdateEntity un) {
		Optional.ofNullable(un.getDatas()).ifPresent((d)->{
			List<CommonItem> dataList = JsonUtils.json2List(d, CommonItem.class);
			if(dataList.isEmpty()){
				throw new RuntimeException("dataList必须有数据!");
			}
			un.setDataList(dataList);
		});
		Optional.ofNullable(un.getConditions()).ifPresent((c)->{
			List<CommonItem> conditionList = JsonUtils.json2List(c, CommonItem.class);
			if(!conditionList.isEmpty()){
				un.setConditionList(conditionList);
			}
		});
		return mapper.updateAny(un);
	}

	

	

}
