package com.lg.model.dto;

import java.io.Serializable;

public class Store implements Serializable {
	private String storeName;
	
	public Store() {
		super();
	}
	
	public Store(String storeName) {
		super();
		this.storeName = storeName;
	}
	
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
