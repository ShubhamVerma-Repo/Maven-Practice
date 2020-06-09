package com.demo;

import java.sql.*;
import java.io.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

public class StoreExcelInDb {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
            
            FileInputStream input = new FileInputStream("countrycode.xls");
            POIFSFileSystem fs = new POIFSFileSystem( input );
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            
            for(int i=1; i<=sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);
                String id = row.getCell(0).getStringCellValue();
                int id1=Integer.parseInt(id);
                
                String name = row.getCell(1).getStringCellValue();               
                String desg = row.getCell(3).getStringCellValue();
                
                PreparedStatement pst=con.prepareStatement("insert into Employee values (?,?,?)");
    			pst.setInt(1, id1);
    			pst.setString(2,name);
    			pst.setString(3, desg);
    			
    			pst.executeUpdate();
    			
                System.out.println("Import rows "+i);
            }
            con.commit();
            pst.close();
            con.close();
            input.close();
            System.out.println("Success import excel to mysql table");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
		
		
	}

}
