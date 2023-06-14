package exceloperations;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Iterator;


import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ReadingExcel {

	public static void main(String[] args) {
		//Read all the data from all the sheets in file
		
		String excelFilePath =".\\datafiles\\emp1.xlsx"; //Create file path
		
		try
		{
			//We connect the stream to that file so inputstream is representing the file
			FileInputStream inputstream = new FileInputStream(excelFilePath); 
			
			try (//Get the workbook using the inputstream
			XSSFWorkbook workbook = new XSSFWorkbook(inputstream)) {
				//Get the sheet from the workbook
				System.out.println("Reading Employee Sheet");
				XSSFSheet sheet1 = workbook.getSheet("Employee");
				ReadSheet(sheet1);
				System.out.println();
				
				//Get the other sheet from the workbook
				System.out.println("Reading EmployeeInfo Sheet");
				XSSFSheet sheet2 = workbook.getSheet("EmployeeInfo");
				ReadSheet(sheet2);
			}
			
			inputstream.close();
		}
		catch(Exception e)
		{
			System.out.println("Error occured: " + e.toString());
		}
	}

	@SuppressWarnings("rawtypes")
	private static void ReadSheet(XSSFSheet sheet) {
		// Using Iterator method read the data
		
		Iterator rowIterator = sheet.iterator();		//Iterator for sheet
		
		while(rowIterator.hasNext()) {
			XSSFRow row = (XSSFRow)rowIterator.next(); //Typecast this or it will return the row object
													//Now converting it into row and storing in row
			
			Iterator cellIterator = row.cellIterator();	//Iterator for cell
			
			while(cellIterator.hasNext()) {
				XSSFCell cell =(XSSFCell)cellIterator.next(); //Typecast this or it will return the cell object
														//Now converting it into cell and storing in cell
				
				
				//Use Switch statement to get the cell type
				
				switch(cell.getCellType()) {
						
					case STRING: 
						System.out.print(cell.getStringCellValue());
						break;
					case NUMERIC: 
						System.out.print(cell.getNumericCellValue());
						break;
					case BOOLEAN: 
						System.out.print(cell.getBooleanCellValue());
						break;
					default:
						break;
				
				}
				
								
				System.out.print(" |  ");
			}
			System.out.println();
			
		}
	}
}
