package com.mastek.demo;
import java.sql.*;  
import java.io.*;
public class PreparedStatementInterfaceInsertNRowsApp 
{
	public static void main (String args [])throws Exception
	{  
		Class.forName ("oracle.jdbc.driver.OracleDriver");  
		Connection connection = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe" , "c##ADUser" , "root");  
		PreparedStatement preparedStatement = connection.prepareStatement ("INSERT INTO EmployeeInsertNRows VALUES (? , ? , ?)");  
		BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (System.in));  
		do
		{  
			System.out.println ("Enter Id : ");  
			int id = Integer.parseInt (bufferedReader.readLine());  
			System.out.println ("\nEnter Name : ");  
			String name = bufferedReader.readLine();  
			System.out.println ("\nEnter Salary : ");  
			float salary = Float.parseFloat (bufferedReader.readLine());  
			preparedStatement.setInt (1 , id);  
			preparedStatement.setString (2 , name);  
			preparedStatement.setFloat (3 , salary);  
			int i=preparedStatement.executeUpdate();  
			System.out.println (i + " Records Affected.");  
			System.out.println ("\nDo You Want To Continue ? : Yes/No : ");  
			String s = bufferedReader.readLine();  
			if (s.startsWith ("No"))
			{  
				break;  
			}  
		}
		while(true);    
			connection.close();  
	}
}