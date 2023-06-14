package com.testing.tests.day3;


import java.io.IOException;
import java.util.Iterator;
import java.io.File;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;



public class UsernamePassword {
	
	@Test
	public static void test() throws InvalidFormatException, IOException {
		
		String filePath = System.getProperty("user.dir")+"/datafiles2/UserPass.xlsx";
		String sheetName = "Sheet1";
		
		System.out.println("Reading " + sheetName + " from Excel file " + filePath);
		String[][] data = readExcelSheet(filePath, sheetName);//Calls the readExcelSheet()
										//method to read data from the excel file and assign
										//it to two dimensional array 'data'
		
		
		//For loop iterates over each row in the 'data' array and extracts the username and 
		//password from each row 
		
		for(String[] row : data) {
			String username = row[0];
			String password = row[1];
			automateLogin(username, password); //calls the automateLogin() method
												//passing the extracted values
		}
	}
	
	//This method represents the automated login functionality
	@Test(dataProvider = "ExcelSheet")
	public static void automateLogin(String name, String pass) {
		System.out.println("username=" + name + " password=" + pass);
	}
	
		@DataProvider(name="ExcelSheet")
	public static String[][] readExcelSheet(String filePath, String sheetName) throws InvalidFormatException, IOException
	{
		String[][] data = null;
		int rowIndex = 0;			//storing the data in row index
		int cellIndex = 0;			//storing the data in cell index
		
		File excelFile = new File(filePath);
		try (XSSFWorkbook workbook = new XSSFWorkbook(excelFile)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalCells = 0;
			
			if (totalRows >= 1) {
				totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
			}
			
			System.out.println(sheetName + " has " + totalRows + " rows and " + totalCells + " cells");
			
			data = new String[totalRows][totalCells];
			
			Iterator<Row> rows = sheet.iterator();

			while (rows.hasNext()) {
				Row row = rows.next();
				Iterator<Cell> cells = row.iterator();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					data[rowIndex][cellIndex] = cell.getStringCellValue();
					cellIndex++;
				}
				
				rowIndex++;
				cellIndex=0;
			}
			
			workbook.close();
		}
		
		return data;
	}
}
