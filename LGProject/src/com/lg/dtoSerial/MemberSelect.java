package com.lg.dtoSerial;

import java.io.Serializable;
import java.util.List;

import com.lg.model.dto.Member;

public class MemberSelect implements Serializable {
	List<Member> list = null;

	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) {
		this.list = list;
	}

	public MemberSelect(List<Member> list) {
		super();
		this.list = list;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MemberSelect";
	}
}
