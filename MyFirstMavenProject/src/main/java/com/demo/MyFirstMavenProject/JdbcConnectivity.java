package com.demo.MyFirstMavenProject;

import java.sql.*;

public class JdbcConnectivity 
{
	
	public static void main(String[]args)
	{
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
			
			PreparedStatement pst=con.prepareStatement("insert into Employee values (?,?,?)");
			pst.setInt(1, 3);
			pst.setString(2,"sakshi");
			pst.setString(3, "GET");
			
			int queryInsertion=pst.executeUpdate();
			
			System.out.println("no. of quert inserted :  "+queryInsertion);
			
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
	}

}
