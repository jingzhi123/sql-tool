package com.jz.tools.sql.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class SqlController {
	@Autowired
	private SqlService sqlService;
	
	@PostMapping(value = "/anyquery")
	public MessageModel queryAny(@Validated QueryEntity qn,BindingResult br){
		MessageModel data = MessageModel.success("查询成功!");
		
		
		List<PageData> list = new ArrayList<PageData>();
		try {
			if(br.hasFieldErrors()){
				List<FieldError> errors = br.getFieldErrors();
				String errorString = "";
				for (Iterator<FieldError> iterator = errors.iterator(); iterator.hasNext();) {
					FieldError fieldError = (FieldError) iterator.next();
					errorString += fieldError.getDefaultMessage() + (iterator.hasNext()?",":"");
				} 
				throw new RuntimeException(errorString);
			}
			list = sqlService.queryAny(qn);
		} catch (Exception e) {
			data = MessageModel.error(e.getMessage());
			e.printStackTrace();
		}
		data.setData(list);
		return data;
	}
	
	@PostMapping(value = "/anyinsert")
	public MessageModel insertAny(@Validated InsertEntity in,BindingResult br){
		MessageModel data = MessageModel.success("新增成功!");
		int result = 0;
		try {
			if(br.hasFieldErrors()){
				List<FieldError> errors = br.getFieldErrors();
				String errorString = "";
				for (Iterator<FieldError> iterator = errors.iterator(); iterator.hasNext();) {
					FieldError fieldError = (FieldError) iterator.next();
					errorString += fieldError.getDefaultMessage() + (iterator.hasNext()?",":"");
				} 
				throw new RuntimeException(errorString);
			}
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
	public MessageModel updateAny(@Validated UpdateEntity un,BindingResult br){
		MessageModel data = MessageModel.success("修改成功!");
		int result = 0;
		try {
			if(br.hasFieldErrors()){
				List<FieldError> errors = br.getFieldErrors();
				String errorString = "";
				for (Iterator<FieldError> iterator = errors.iterator(); iterator.hasNext();) {
					FieldError fieldError = (FieldError) iterator.next();
					errorString += fieldError.getDefaultMessage() + (iterator.hasNext()?",":"");
				} 
				throw new RuntimeException(errorString);
			}
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
	public MessageModel deleteAny(@Validated DeleteEntity dn,BindingResult br){
		MessageModel data = MessageModel.success("删除成功!");
		int result = 0;
		try {
			if(br.hasFieldErrors()){
				List<FieldError> errors = br.getFieldErrors();
				String errorString = "";
				for (Iterator<FieldError> iterator = errors.iterator(); iterator.hasNext();) {
					FieldError fieldError = (FieldError) iterator.next();
					errorString += fieldError.getDefaultMessage() + (iterator.hasNext()?",":"");
				} 
				throw new RuntimeException(errorString);
			}
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