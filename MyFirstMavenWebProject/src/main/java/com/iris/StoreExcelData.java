package com.iris;

import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.*;
import java.sql.*;

public class StoreExcelData {

	public static void main(String[] args) throws Exception
	{              
		
		int result=0;
		
		
        /* Create Connection objects */
        Class.forName ("oracle.jdbc.driver.OracleDriver"); 
        
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "root");
        
        PreparedStatement sql_statement = null;
        
        /*String jdbc_insert_sql = "insert into TestExcelStorage "
        		+ "(DateValue,TeamMember,Project,Module,Phase,Activity,Description,RefID/TicketID,TotalHrs,HrsMins ) "
        		+ " values (?,?,?,?,?,?,?,?,?,?)";*/
        
        String jdbc_insert_sql = "insert into TestExcelStorage "
        		+ "(Module,Phase) "
        		+ " values (?,?)";
        
        String FILE_NAME = "C://Users//shubham.verma//Desktop//OpRisk_TimeSheet.xlsx";
        
        sql_statement = conn.prepareStatement(jdbc_insert_sql);
        
        /* We should now load excel objects and loop through the worksheet data */
        FileInputStream input_document = new FileInputStream(new File(FILE_NAME));
        
        /* Load workbook */
        XSSFWorkbook  my_xls_workbook = new XSSFWorkbook (input_document);
        
        /* Load worksheet */
        XSSFSheet  my_worksheet = my_xls_workbook.getSheetAt(0);
        
        // we loop through and insert data
        Iterator<Row> rowIterator = my_worksheet.iterator(); 
       
        while(rowIterator.hasNext())
        {
                Row row = rowIterator.next(); 
                
                Iterator<Cell> cellIterator = row.cellIterator();
                
                        while(cellIterator.hasNext())
                        {
                                Cell cell = cellIterator.next();
                                
                               
                                
                                /*sql_statement.setString(1, cell.getStringCellValue());
                                
                                sql_statement.setString(2, cell.getStringCellValue());
                                
                                sql_statement.setString(3, cell.getStringCellValue());*/
                                
                                //System.out.println("type of cell "+cell.getCellType());
                                
                                
                               
                                
                                
                                /*switch(cell.getCellType())
                                { 
                                
                                case Cell.CELL_TYPE_STRING: //handle string columns
                                        
                                	sql_statement.setString(1, cell.getStringCellValue());
                                        
                                	sql_statement.setString(2, cell.getStringCellValue());
                                	
                                	sql_statement.setString(3, cell.getStringCellValue());
                                    
                                	sql_statement.setString(4, cell.getStringCellValue());
                                	
                                	sql_statement.setString(5, cell.getStringCellValue());
                                    
                                	sql_statement.setString(6, cell.getStringCellValue());
                                	
                                	sql_statement.setString(7, cell.getStringCellValue());
                                    
                                	sql_statement.setString(8, cell.getStringCellValue());
                                	
                                	sql_statement.setString(10, cell.getStringCellValue());
                                	
                                        break;
                                case Cell.CELL_TYPE_NUMERIC: //handle double data
                                	
                                        sql_statement.setFloat(9, (float) cell.getNumericCellValue());
                                    
                                        break;
                                }
*/                               
                                
                               /* switch(cell.getCellType())
                                { 
                                
                                case Cell.CELL_TYPE_STRING: //handle string columns
                                        
                                	sql_statement.setString(1, cell.getStringCellValue());
                                        
                                	sql_statement.setString(2, cell.getStringCellValue());                                	
                                	
                                	
                                        break;
                                case Cell.CELL_TYPE_NUMERIC: //handle double data
                                	
                                        //sql_statement.setFloat(9, (float) cell.getNumericCellValue());
                                    
                                        break;
                                }
                                */
                                
                                
                                /*sql_statement.setString(1, cell.getStringCellValue());
                                
                            	sql_statement.setString(2, cell.getStringCellValue());*/
                            	
                            	/*sql_statement.setString(3, cell.getStringCellValue());
                                
                            	sql_statement.setString(4, cell.getStringCellValue());
                            	
                            	sql_statement.setString(5, cell.getStringCellValue());
                                
                            	sql_statement.setString(6, cell.getStringCellValue());
                            	
                            	sql_statement.setString(7, cell.getStringCellValue());
                                
                            	sql_statement.setString(8, cell.getStringCellValue());
                            	
                            	sql_statement.setString(9, cell.getStringCellValue());
                            	
                            	sql_statement.setString(10, cell.getStringCellValue());*/
                                
                                
                                
                                
                                
                                
                        }
        //we can execute the statement before reading the next row
       // result=sql_statement.executeUpdate();
        }
        
        System.out.println("no. of records inserted : "+result);
        
        
        Statement stmt=conn.createStatement();
        
        ResultSet rs= stmt.executeQuery("select * from TestExcelStorage");
        
        while(rs.next()){
            //Retrieve by column name
            String module  = rs.getString("Module");
            String phase  = rs.getString("Phase");
           

            //Display values
            System.out.println();
            System.out.print("ID: " + module);
            System.out.println();
            System.out.print("Age: " + phase);
            System.out.println();
        }
        
        /* Close input stream */
        input_document.close();
        /* Close prepared statement */
        sql_statement.close();
        /* COMMIT transaction */
        conn.commit();
        /* Close connection */
        conn.close();
}

}
