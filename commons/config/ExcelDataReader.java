package config;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
		
	public HashMap<String,HashMap<String,String>> readExcelFile()
	{
		HashMap<String,HashMap<String,String>> master = new HashMap<>();
		
		try{
			FileInputStream file = new FileInputStream(new File(".//reasource//DataFile.xlsx"));
			
			//Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            int totSheets = workbook.getNumberOfSheets();
            
            for(int i=0 ;i<totSheets;i++)
            {
            	XSSFSheet curSheet = workbook.getSheetAt(i);
            	String sheetName = curSheet.getSheetName();
            	int totRows =  curSheet.getLastRowNum();
            	int totColumn = curSheet.getRow(0).getLastCellNum();
            	
            	for(int row=1;row<=totRows;row++)
            	{
            		HashMap<String,String> rowData = new HashMap<>();
            		for(int col=1;col<totColumn;col++)
            		{
            			XSSFCell header = curSheet.getRow(0).getCell(col);
            			XSSFCell cell = curSheet.getRow(row).getCell(col);
            		    String columnName = header.getStringCellValue();
            		    String columnValue = cell.getStringCellValue();
            		    rowData.put(columnName, columnValue);
            		}
            		String ID = curSheet.getRow(row).getCell(0).getStringCellValue();
            		master.put(sheetName+"-"+ID, rowData);
            	}
            }
            
        
            
		}catch(Exception ex)
		{
			
		}
		
	    return master;
	}


}
