package com.model;

public class SencingDTO {
	
	private String gas;
	private String feeding; 
	private String feedtime;
	
	
	public SencingDTO(String gas, String feeding, String feedtime) {
		super();
		this.gas = gas;
		this.feeding = feeding;
		this.feedtime = feedtime;
	}
	
	
	public String getGas() {
		return gas;
	}
	public void setGas(String gas) {
		this.gas = gas;
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
