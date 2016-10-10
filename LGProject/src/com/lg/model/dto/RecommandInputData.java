package com.lg.model.dto;

import java.io.Serializable;

public class RecommandInputData implements Serializable{
	private String email;
	private String storeName;
	
	public RecommandInputData(){}
	
	public RecommandInputData(String email, String storeName) {
		super();
		this.email = email;
		this.storeName = storeName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	@Override
	public String toString() {
		return "RecommandInputData";
	}
}
