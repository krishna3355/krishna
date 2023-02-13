package com.slokam.helthcare.service;

import com.slokam.helthcare.exception.PatientException;

public interface IDataImportService {
	public void importData(String filePath) throws  PatientException;
}
