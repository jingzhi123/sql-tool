package com.jz.tools.entity;

public class MessageModel {
	private String message;
	private int status;
	private Object data;
	
	public MessageModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MessageModel(String message, int status, Object data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}
	
	public static MessageModel success(String message,Object data){
		MessageModel mm = new MessageModel(message, 1, data);
		return mm;
	}
	public static MessageModel success(String message){
		MessageModel mm = new MessageModel(message, 1, null);
		return mm;
	}
	
	public static MessageModel error(String message,Object data){
		MessageModel mm = new MessageModel(message, 0, data);
		return mm;
	}
	
	public static MessageModel error(String message){
		MessageModel mm = new MessageModel(message, 0, null);
		return mm;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MessageModel [message=" + message + ", status=" + status + ", data=" + data + "]";
	}
	
	
	
}
