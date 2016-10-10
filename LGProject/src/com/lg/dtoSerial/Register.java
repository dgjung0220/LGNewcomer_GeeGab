package com.lg.dtoSerial;

import java.io.Serializable;

public class Register implements Serializable {
	
	private String email;
	private String passwd;
	private String passwdCheck;
	private String name;
	private String phone;
	private String addr;
	
	
	public Register(String email, String passwd, String passwdCheck,
			String name, String phone, String addr) {
		super();
		this.email = email;
		this.passwd = passwd;
		this.passwdCheck = passwdCheck;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getPasswdCheck() {
		return passwdCheck;
	}
	public void setPasswdCheck(String passwdCheck) {
		this.passwdCheck = passwdCheck;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "Register";
	}
}
