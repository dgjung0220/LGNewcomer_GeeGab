package com.lg.model.dto;

import java.io.Serializable;

public class Storelist implements Serializable {
	private String storeNo;
	private String storeName;

	
	public Storelist() {}

	public Storelist(String storeName) {
		super();
		this.storeNo = null;
		this.storeName = storeName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	
}
