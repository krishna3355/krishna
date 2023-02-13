package com.slokam.helthcare.util;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DataImport {

	public static void main(String[] args) {
		//List<Visiting> objects = getData("G:\\data\\f23\\HospatalDBData5.xls", "Visiting.java", Visiting.class);
		/*for (Visiting visiting : objects) {
			System.out.println(visiting);
		}*/
		//Map<Integer, Integer> map = getMap(objects,Visiting.class);
		//System.out.println(map);
	}
	

	public static <T>  Map<Integer, Integer> getMap(List<T> objects, Class cls){
		Map<Integer, Integer> map  = new HashMap<>();
		Field f = null ;
		try {
			f = cls.getDeclaredField("id");
			f.setAccessible(true);
			int i=2;
			for (Object object : objects) {
				map.put(i, (Integer)f.get(object));
				i++;
			}
		}catch(NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		return map;
	}
	public static <T> List<T> getData(String filePath, String sheetName,
			Class cls ,Map<Class, Map<Integer,Integer>> map) {
		List<T> objets = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			int number = sheet.getLastRowNum();
			Field[] fields = cls.getDeclaredFields();
			HSSFRow headerRow = sheet.getRow(0);
			int headersCount = headerRow.getLastCellNum();
			String headerArray[] = new String[headersCount];
			for (int i = 0; i < headersCount; i++) {
				headerArray[i] = headerRow.getCell(i).getStringCellValue();
			}
			for (int i = 1; i <= number; i++) {
				HSSFRow row = sheet.getRow(i);
				System.out.println("Row start " + i);
				T obj = (T) cls.newInstance();
				
				for (int j = 0; j < headersCount; j++) {
					if (headerArray[j].contains(":")) {
						String[] values =headerArray[j].split(":");
						String fieldName = values[0];
						String className = values[1];
						Class refClass = Class.forName(className);
						Object refObj = refClass.newInstance();
						int refValue = (int)row.getCell(j).getNumericCellValue();
						Map<Integer, Integer> ex_db_map = map.get(refClass);
						int dbValue = ex_db_map.get(refValue);
						// 
						Field refField = refClass.getDeclaredField("id");
						refField.setAccessible(true);
						refField.set(refObj, dbValue);
						Field mainFeild = cls.getDeclaredField(fieldName);
						mainFeild.setAccessible(true);
						mainFeild.set(obj, refObj);
					} else {
						Field field = cls.getDeclaredField(headerArray[j]);
						Object value = null;
						if (field.getType() == String.class) {
							value = row.getCell(j).getStringCellValue();
						} else if (field.getType() == Date.class) {
							value = row.getCell(j).getDateCellValue();
						} else if (field.getType() == Long.class) {
							value = (long) row.getCell(j).getNumericCellValue();
						} else if (field.getType() == Integer.class) {
							value = (int) row.getCell(j).getNumericCellValue();
						} else if (field.getType() == Double.class) {
							value = (double) row.getCell(j).getNumericCellValue();
						}

						field.setAccessible(true);
						field.set(obj, value);
					}
				}
				System.out.println("Row End " + i);
				objets.add(obj);
			}
			fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objets;

	}

}
