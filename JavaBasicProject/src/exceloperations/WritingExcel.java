package exceloperations;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;



public class WritingExcel {

	public static void main(String[] args) {
		// Writing data
		
		
		//Create a new workbook
		XSSFWorkbook workbook = new XSSFWorkbook();	
		
		//Create a new sheet
		XSSFSheet sheet = workbook.createSheet("Emp Info");
		

		//Change the background to black and foreground to white
		XSSFCellStyle style = workbook.createCellStyle(); //create a style object
		
		//Apply certain settings to the style
		style.setFillForegroundColor(IndexedColors.BLACK.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		//Set the Font color to white
		XSSFFont font = workbook.createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
					
		
		ArrayList<Object[]> empdata = new ArrayList<Object[]>();
		
		empdata.add(new Object[] {"Empid", "Name", "Job"});
		empdata.add(new Object[] {"101", "John", "Programmer"});
		empdata.add(new Object[] {"102", "Sheila", "Finance"});
		empdata.add(new Object[] {"103", "Martin", "Analyst"});
		empdata.add(new Object[] {"104", "Carol", "Manager"});
		
		//Using Enhanced For loop
		
		int rownum =0;
		
		for(Object[] emp: empdata) {
			
			XSSFRow row = sheet.createRow(rownum++);
			
			int cellnum =0;
			
			for(Object value: emp) {
				
				XSSFCell cell = row.createCell(cellnum++);
				
				if (value instanceof String) 
					cell.setCellValue((String)value);
				
					if(cellnum==2 && rownum>1) {
						//Add hyperlink to the "Employee Name" column
						CreationHelper creationHelper =workbook.getCreationHelper();
						Hyperlink hyperlink = creationHelper.createHyperlink(HyperlinkType.URL);
						hyperlink.setAddress("https://www.google.com/q="+(String)value);
						cell.setHyperlink(hyperlink);
						cell.setCellStyle(style); //Apply the cell style
					}
			
					else if (value instanceof Integer) {
						cell.setCellValue ((Integer)value);
					}
					else if (value instanceof Boolean) {
						cell.setCellValue((Boolean)value);
					}	
					else {
						cell.setCellStyle(style);
					}
			}
				
		}
			
			
				
		try
		{
			String filePath = ".\\datafiles\\employee.xlsx";
			FileOutputStream outstream = new FileOutputStream (filePath);
			workbook.write(outstream);
			outstream.close();
			System.out.println("Employee.xls file written successfully....");
			workbook.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found: " + e.toString());
		}
		catch (IOException e) {
			System.out.println("Error occurred while writing the file: " +e.toString());
		}		
		
	}

	}

