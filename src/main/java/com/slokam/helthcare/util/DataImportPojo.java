package com.slokam.helthcare.util;

public class DataImportPojo <T> {

	private String sheetName;
	private Class entityClass;
	private Object daoObject;

	
	public DataImportPojo(String sheetName, Class entityClass, Object daoObject) {
		super();
		this.sheetName = sheetName;
		this.entityClass = entityClass;
		this.daoObject = daoObject;
		//this.t=t;
	}
	




	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public Class getEntityClass() {
		return entityClass;
	}
	public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}
	public Object getDaoObject() {
		return daoObject;
	}
	public void setDaoObject(Object daoObject) {
		this.daoObject = daoObject;
	}

	
	
}
