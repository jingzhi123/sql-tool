package com.jz.tools.sql.controller;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jz.tools.entity.MessageModel;

@ControllerAdvice
@ResponseBody
public class BaseControllerAdvice {

	@ExceptionHandler(BindException.class)
	public MessageModel catchBindException(BindException e) {
		BindingResult br = e.getBindingResult();
		String errorString = "";
		if (br.hasFieldErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (Iterator<FieldError> iterator = errors.iterator(); iterator.hasNext();) {
				FieldError fieldError = (FieldError) iterator.next();
				errorString += fieldError.getDefaultMessage() + (iterator.hasNext() ? "," : "");
			}
		}
		MessageModel data = MessageModel.error(errorString);
		data.setData(Collections.EMPTY_LIST);
		return data;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public MessageModel catchConstraintViolationException(ConstraintViolationException e) {
		String es = "";
		String errorString = e.getMessage();
		String[] split = errorString.split(",");
		for (String string : split) {
			es += string.split(":")[1] + ",";
		}
		es = es.substring(0, es.length() - 1);
		MessageModel data = MessageModel.error(es);
		data.setData(Collections.EMPTY_LIST);
		return data;
	}
}
