package com.model;

public class MemberDTO {
	private String name;
	private String phoneNumber;
	private String id;
	private String pw;

	public MemberDTO() {
		super();
	}

	public MemberDTO(String name, String phoneNumber, String id, String pw) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
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

}
