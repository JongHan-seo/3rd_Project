package com.model;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String address;
	private String serialcode;
	private String phoneNumber;
	
	
	public MemberDTO() {   }
	
	public MemberDTO(String id, String pw, String name, String address, String serialcode, String phoneNumber) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.serialcode = serialcode;
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSerialcode() {
		return serialcode;
	}

	public void setSerialcode(String serialcode) {
		this.serialcode = serialcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
	

	
	
	
	
	

}
