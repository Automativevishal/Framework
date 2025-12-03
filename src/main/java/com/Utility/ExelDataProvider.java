package com.Utility;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelDataProvider {

	public XSSFWorkbook wb;
	public ExelDataProvider () throws IOException {
		
		
		
		String path ="D:\\Java Student\\Hybrid_Framework\\TestData\\data.xlsx";
		FileInputStream file= new FileInputStream(path);
		wb =new XSSFWorkbook(file);
		
		
	}
	
	public String  getstringdata(String SheetName, int row, int cell) {
		
		return wb.getSheet(SheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	
	
}
