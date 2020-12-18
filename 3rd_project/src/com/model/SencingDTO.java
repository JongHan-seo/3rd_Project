package com.model;

public class SencingDTO {
	
	private String gas;
	private String temp;
	private String water;
	private String feeding; 
	private String uptime;
	private String upsys;

	
	public SencingDTO() {	}
	
	public SencingDTO(String temp, String uptime) {
		super();
		this.temp = temp;
		this.uptime = uptime;
	}
	
	public SencingDTO(String gas, String temp, String water, String feeding, String uptime) {
		super();
		this.gas = gas;
		this.temp = temp;
		this.water = water;
		this.feeding = feeding;
		this.uptime = uptime;
	}
	

	public SencingDTO(String gas, String temp, String water, String feeding, String uptime, String upsys) {
		super();
		this.gas = gas;
		this.temp = temp;
		this.water = water;
		this.feeding = feeding;
		this.uptime = uptime;
		this.upsys = upsys;
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

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public String getUpsys() {
		return upsys;
	}

	public void setUpsys(String upsys) {
		this.upsys = upsys;
	}

}
