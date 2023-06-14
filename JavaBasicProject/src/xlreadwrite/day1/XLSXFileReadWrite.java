package xlreadwrite.day1;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;



public class XLSXFileReadWrite {

	
	public static void readCellDataFromXLfile () throws InvalidFormatException, IOException{
		
		File filePath = new File(System.getProperty("user.dir")+"/datafiles/Emp1.xlsx");//Path where the file is stored
		try (XSSFWorkbook workbook = new XSSFWorkbook(filePath)) {
			XSSFSheet sheet = workbook.getSheet("Employee");		//Particular sheet from the spreadsheet
			XSSFRow row = sheet.getRow(2);						//went to Row number 2
			XSSFCell cell = row.getCell(1);						//went to cell number 2
			
			//Extracting the string value from the cell
			
			
			System.out.println("Data at row 2 and cell 1 ===" +cell.getStringCellValue());
		}
	}
	public static void main(String[] args) {
		// Reading the file
		
		try {
			readCellDataFromXLfile();
			
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	//printStackTrace() method is a tool to handle exceptions and errors
									//It is a method of Java's throwable class which prints the throwable along with other 
								//details like the line number and class name where the exception occurred
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		//printStackTrace is very useful in diagnosing exceptions.
		}
		
		
	}

}
