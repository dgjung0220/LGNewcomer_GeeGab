package com.lg.model.dto;

import java.io.Serializable;

public class Cardlist implements Serializable{
	private String cardNo;
	private String cardName;
	
	public Cardlist() {}
	public Cardlist(String cardName) {
		super();
		this.cardNo = cardNo;
		this.cardName = cardName;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
}
