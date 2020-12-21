package com.model;

public class MemberDTO {
	private String name;
	private String phon;
	private String address;
	private String id;
	private String pw;
	private String rpw;

	public MemberDTO() {
		super();
	}

	public MemberDTO(String name, String phone, String address, String id, String pw, String rpw) {
		super();
		this.name = name;
		this.phon = phone;
		this.address = address;
		this.id = id;
		this.pw = pw;
		this.rpw = rpw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhon() {
		return phon;
	}

	public void setPhone(String phon) {
		this.phon = phon;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
