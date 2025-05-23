package com.swaglabs.parameters;

import java.io.IOException;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public List<String> excelReaderMethod(String dataCells) {
		List<String> credentials = new ArrayList<String>();
		
		String[] cred = dataCells.split("");
		int rowNum = Integer.parseInt(cred[0]);
		int cellNum = Integer.parseInt(cred[1]);
		
		XSSFWorkbook xf;
		try {
			xf = new XSSFWorkbook("/Users/surajsingh/eclipse-workspace/SwaglabsDemo/src/test/resources/ExcelFiles/loginCredentials.xlsx");
			XSSFSheet sheet = xf.getSheetAt(0);
			
			credentials.add(sheet.getRow(rowNum).getCell(cellNum).toString());
			credentials.add("secret_sauce");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return credentials;
	}
}
