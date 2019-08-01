package com.jz.tools.sql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jz.tools.entity.MessageModel;
import com.jz.tools.sql.service.SqlService;
import com.jz.tools.util.PageData;

@RestController
@RequestMapping("/sql")
public class SqlController {
	@Autowired
	private SqlService sqlService;
	
	@PostMapping(value = "/anyquery")
	public MessageModel queryAny(String dbName,@RequestParam("tableName") String tableName,String conditions,String order,String limit){
		MessageModel data = MessageModel.success("查询成功!");
		List<PageData> list = null;
		try {
			list = sqlService.queryAny(dbName, tableName, conditions, order, limit);
			data.setData(list);
		} catch (Exception e) {
			data = MessageModel.error(e.getMessage());
			data.setData(e.getMessage());
			e.printStackTrace();
		}
		return data;
	}
	
	@PostMapping(value = "/anyinsert")
	public MessageModel insertAny(String dbName,@RequestParam("tableName") String tableName,@RequestParam("datas") String datas){
		MessageModel data = MessageModel.success("新增成功!");
		int result = 0;
		try {
			result = sqlService.insertAny(dbName, tableName, datas);
			data.setMessage("成功新增" + result + "条");
			data.setData(result);
		} catch (Exception e) {
			data = MessageModel.error(e.getMessage());
			data.setData(e.getMessage());
			e.printStackTrace();
		}
		return data;
	}
	
	@PostMapping(value = "/anyupdate")
	public MessageModel updateAny(String dbName,@RequestParam("tableName") String tableName,@RequestParam("datas") String datas,String conditions){
		MessageModel data = MessageModel.success("修改成功!");
		int result = 0;
		try {
			result = sqlService.updateAny(dbName, tableName, datas,conditions);
			data.setMessage("成功修改" + result + "条");
			data.setData(result);
		} catch (Exception e) {
			data = MessageModel.error(e.getMessage());
			data.setData(e.getMessage());
			e.printStackTrace();
		}
		return data;
	}
	
	@PostMapping(value = "/anydelete")
	public MessageModel deleteAny(String dbName,@RequestParam("tableName") String tableName,String conditions){
		MessageModel data = MessageModel.success("删除成功!");
		int result = 0;
		try {
			result = sqlService.deleteAny(dbName, tableName, conditions);
			data.setMessage("成功删除" + result + "条");
			data.setData(result);
		} catch (Exception e) {
			data = MessageModel.error(e.getMessage());
			data.setData(e.getMessage());
			e.printStackTrace();
		}
		return data;
	}
}