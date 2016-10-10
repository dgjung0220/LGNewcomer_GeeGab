package com.lg.dtoSerial;

import java.io.Serializable;

public class SearchStringToken implements Serializable {
	private String token;
	
	public SearchStringToken() {
		super();
	}

	public SearchStringToken(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "SearchStringToken";
	}
	
	
}
