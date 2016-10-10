package com.lg.model.dto;

import java.io.Serializable;

public class DscntInfo implements Serializable {
	private String cardName;
	private String storeName;
	private float discountRate;
		
	public DscntInfo() {}

	public DscntInfo(String cardName, String storeName, float discountRate) {
		super();
		this.cardName = cardName;
		this.storeName = storeName;
		this.discountRate = discountRate;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public float getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "DscntInfo";
	}
}
