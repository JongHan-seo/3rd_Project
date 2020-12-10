package com.model;

public class SencingDTO {
	private String nh3 ;
	private String nox; 
	private String alcohol; 
	private String benzene;
	private String smoke; 
	private String co2; 
	private String feeding; 
	private String feedtime;
	
	public SencingDTO(String nh3, String nox, String alcohol, String benzene, String smoke, String co2, String feeding,
			String feedtime) {
		super();
		this.nh3 = nh3;
		this.nox = nox;
		this.alcohol = alcohol;
		this.benzene = benzene;
		this.smoke = smoke;
		this.co2 = co2;
		this.feeding = feeding;
		this.feedtime = feedtime;
	}
	
	
	public String getNh3() {
		return nh3;
	}
	public void setNh3(String nh3) {
		this.nh3 = nh3;
	}
	public String getNox() {
		return nox;
	}
	public void setNox(String nox) {
		this.nox = nox;
	}
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	public String getBenzene() {
		return benzene;
	}
	public void setBenzene(String benzene) {
		this.benzene = benzene;
	}
	public String getSmoke() {
		return smoke;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public String getCo2() {
		return co2;
	}
	public void setCo2(String co2) {
		this.co2 = co2;
	}
	public String getFeeding() {
		return feeding;
	}
	public void setFeeding(String feeding) {
		this.feeding = feeding;
	}
	public String getFeedtime() {
		return feedtime;
	}
	public void setFeedtime(String feedtime) {
		this.feedtime = feedtime;
	}
	
	
	
	
	
	
	

	
	
}
