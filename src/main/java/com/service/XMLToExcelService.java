package com.service;

public interface XMLToExcelService{
	public void createFile(String sheetName)throws Exception;
	public void writeData(String fileName)throws Exception;
}

