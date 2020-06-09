package com.demo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;


public class ExcelRead {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
		String FILE_NAME = "C://Users//shubham.verma//Desktop//OpRisk_TimeSheet.xlsx";
		
		//String FILE_NAME = "C://Users//shubham.verma//Desktop//Sample.xlsx";
		
		int count=0;

		 try {

	            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
	            Workbook workbook = new XSSFWorkbook(excelFile);
	            Sheet datatypeSheet = workbook.getSheetAt(0);
	            Iterator<Row> iterator = datatypeSheet.iterator();

	            while (iterator.hasNext()) {

	                Row currentRow = iterator.next();
	                Iterator<Cell> cellIterator = currentRow.iterator();

	                while (cellIterator.hasNext()) {

	                    Cell currentCell = cellIterator.next();
	                    
	                    System.out.print(currentCell + "--");
	                    
	                    //getCellTypeEnum shown as deprecated for version 3.15
	                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
	                   
	                    
	                   /* if (currentCell.getCellTypeEnum() == CellType.STRING) {
	                        System.out.print(currentCell.getStringCellValue() + "--");
	                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
	                        System.out.print(currentCell.getNumericCellValue() + "--");
	                    }*/
	                    
	                }
	                System.out.println();
	                
                    count++;

	            }
	            
	            
	            System.out.println("total records are : "+count);
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

}
