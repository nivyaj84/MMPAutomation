package org.mmp1.methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	public static String[][] ExcelData(String file_path, int sheet_number) throws Exception 
	{
		File file = new File(file_path);
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			 sheet= wb.getSheetAt(sheet_number);
		     } catch (FileNotFoundException e)
		     {
		       System.out.println("File not found");
		     }
		
			int rowcount = sheet.getLastRowNum()+1;
		    String[][]data= new String[rowcount][2];
			
			for(int i=0;i<rowcount;i++)
			{
				for(int j=0;j<2;j++)
				{
				data[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data[i][j]);
				}
				
			}
			return data;
			
			
	} 
		
		
		
		
		
		
		

		
	
	
	
	
	
	
	
	
	
	

}
