package com.jz.tools.sql.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jz.tools.entity.MessageModel;
import com.jz.tools.sql.entity.DeleteEntity;
import com.jz.tools.sql.entity.InsertEntity;
import com.jz.tools.sql.entity.QueryEntity;
import com.jz.tools.sql.entity.UpdateEntity;
import com.jz.tools.sql.service.SqlService;
import com.jz.tools.util.PageData;

@RestController
@RequestMapping("/sql")
@Validated
public class SqlController {
	@Autowired
	private SqlService sqlService;
	
	@PostMapping(value = "")
	public MessageModel querySql(@Pattern(regexp = "select+",message = "必须有select关键词!") @NotEmpty(message = "sql不能为空!") @RequestParam("sql") String sql){
		MessageModel data = MessageModel.success("查询成功!");
		
		
		List<PageData> list = new ArrayList<PageData>();
		try {
			list = sqlService.querySql(sql);
		} catch (Exception e) {
			data = MessageModel.error(e.getMessage());
			e.printStackTrace();
		}
		data.setData(list);
		return data;
	}
	
	
	@PostMapping(value = "/anyquery")
	public MessageModel queryAny(@Validated QueryEntity qn){
		MessageModel data = MessageModel.success("查询成功!");
		
		
		List<PageData> list = new ArrayList<PageData>();

		try {
			list = sqlService.queryAny(qn);
		} catch (Exception e) {
			data = MessageModel.error(e.getMessage());
			e.printStackTrace();
		}
		data.setData(list);
		return data;
	}
	
	@PostMapping(value = "/anyinsert")
	public MessageModel insertAny(@Validated InsertEntity in){
		MessageModel data = MessageModel.success("新增成功!");
		int result = 0;
		try {
			result = sqlService.insertAny(in);
			data.setMessage("成功新增" + result + "条");
		} catch (Exception e) {
			data = MessageModel.error(e.getMessage());
			e.printStackTrace();
		}
		data.setData(result);
		return data;
	}
	
	@PostMapping(value = "/anyupdate")
	public MessageModel updateAny(@Validated UpdateEntity un){
		MessageModel data = MessageModel.success("修改成功!");
		int result = 0;
		try {
			result = sqlService.updateAny(un);
			data.setMessage("成功修改" + result + "条");
		} catch (Exception e) {
			data = MessageModel.error(e.getMessage());
			e.printStackTrace();
		}
		data.setData(result);
		return data;
	}
	
	@PostMapping(value = "/anydelete")
	public MessageModel deleteAny(@Validated DeleteEntity dn){
		MessageModel data = MessageModel.success("删除成功!");
		int result = 0;
		try {
			result = sqlService.deleteAny(dn);
			data.setMessage("成功删除" + result + "条");
		} catch (Exception e) {
			data = MessageModel.error(e.getMessage());
			e.printStackTrace();
		}
		data.setData(result);
		return data;
	}
}