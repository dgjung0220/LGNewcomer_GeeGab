package com.lg.dtoSerial;

import java.io.Serializable;
import java.util.List;

import com.lg.model.dto.Usercard;

public class UserCardSelectResult implements Serializable {
	List<Usercard> list = null;
	
	public UserCardSelectResult(List<Usercard> list) {
		super();
		this.list = list;
	}
	
	public List<Usercard> getList() {
		return list;
	}
	public void setList(List<Usercard> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserCardSelectResult";
	}
}
