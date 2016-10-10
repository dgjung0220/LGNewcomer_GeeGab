package com.lg.model.dto;

import java.io.Serializable;

public class Member implements Serializable {
	private String memberNo;
	private String email;
	private String passwd;
	private String name;
	private String phone;
	private String addr;
	
	public Member() {}

	public Member(String email, String passwd, String name, String phone,
			String addr) {
		super();
		this.memberNo = null;
		this.email = email;
		this.passwd = passwd;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	
	public Member(String errmsg) {
		this.email = errmsg;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "member";
	}
}
