package com.lg.dtoSerial;

import java.io.Serializable;

public class UserCardSelect implements Serializable{
	private String email;

	public UserCardSelect(String email) {
		super();
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "userCardSelect";
	}
}
