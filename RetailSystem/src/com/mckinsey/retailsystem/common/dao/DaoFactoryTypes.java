package com.mckinsey.retailsystem.common.dao;

public enum DaoFactoryTypes {
	
	FILE("file"), 
	DB("db");
	
	private final String type;
	
	DaoFactoryTypes (String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString() {
		return this.type;
	}

}
