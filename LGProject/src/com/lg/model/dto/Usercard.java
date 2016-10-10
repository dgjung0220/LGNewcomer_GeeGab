package com.lg.model.dto;

import java.io.Serializable;

public class Usercard implements Serializable {
	private String userCardNo;
	private String cardID;
	private String email;
	private String cardName;
	private String cardType;
	private String cardAlias;
	
	public Usercard() {}

	public Usercard(String cardID, String email, String cardName, String cardType,
			String cardAlias) {
		super();
		this.userCardNo = null;
		this.cardID = cardID;
		this.email = email;
		this.cardName = cardName;
		this.cardType = cardType;
		this.cardAlias = cardAlias;
	}

	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardAlias() {
		return cardAlias;
	}
	public void setCardAlias(String cardAlias) {
		this.cardAlias = cardAlias;
	}
	
	@Override
	public String toString() {
		return "userCard";
	}
}
