package com.model;

public class SencingDTO {
	
	private String gas;
	private String temp;
	private String water;
	private String feeding; 
	private String feedtime;

	public SencingDTO(String gas, String temp, String water, String feeding, String feedtime) {
		super();
		this.gas = gas;
		this.temp = temp;
		this.water = water;
		this.feeding = feeding;
		this.feedtime = feedtime;
	}

	public String getGas() {
		return gas;
	}

	public void setGas(String gas) {
		this.gas = gas;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
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
