package com.michelle;

public class Country {
	
	private String name;
	private boolean home;
	
	public Country(String name, boolean home) {
		super();
		this.name = name;
		this.home = home;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHome() {
		return home;
	}
	public void setHome(boolean home) {
		this.home = home;
	}

}
