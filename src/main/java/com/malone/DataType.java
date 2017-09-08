package com.malone;

public enum DataType {
	VARCHAR2("String"),DATE("Date"),NUMBER("Integer");
	
	String name;
	
	DataType(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static String getDataType(String dataType){
		DataType[] types =	DataType.values();
		for(DataType type : types){
			if(type.toString().equals(dataType)){
				return type.getName();
			}
		}
		return VARCHAR2.getName();
	}
	
	public static void main(String[] args) {
	
	}
	
	
}
