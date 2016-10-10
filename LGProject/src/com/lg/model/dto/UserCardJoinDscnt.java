package com.lg.model.dto;

import java.io.Serializable;

public class UserCardJoinDscnt implements Serializable {
	private String cardName;
	private String cardAlias;
	private String cardID;
	private String cardType;
	private String discountRate;
	
	public UserCardJoinDscnt() {}
	public UserCardJoinDscnt(String cardName, String cardAlias, String cardID,
			String cardType, String discountRate) {
		super();
		this.cardName = cardName;
		this.cardAlias = cardAlias;
		this.cardID = cardID;
		this.cardType = cardType;
		this.discountRate = discountRate;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardAlias() {
		return cardAlias;
	}
	public void setCardAlias(String cardAlias) {
		this.cardAlias = cardAlias;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(String discountRate) {
		this.discountRate = discountRate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserCardJoinDscnt";
	}
	
}
