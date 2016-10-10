package com.lg.dtoSerial;

import java.io.Serializable;

public class Store implements Serializable {
	private String storeName;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Store(String storeName) {
		super();
		this.storeName = storeName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Store";
	}
}
