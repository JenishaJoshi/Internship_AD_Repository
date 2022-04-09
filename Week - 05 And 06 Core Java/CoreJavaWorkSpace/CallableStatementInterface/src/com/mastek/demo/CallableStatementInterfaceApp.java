package com.mastek.demo;
import java.sql.*;
public class CallableStatementInterfaceApp 
{
	public static void main (String[] args) throws Exception
	{  	  
		Class.forName ("oracle.jdbc.driver.OracleDriver");  
		Connection connection = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe" , "c##ADUser" , "root");  
		CallableStatement callableStatement = connection.prepareCall ("{call insertR (? , ?)}");  
		callableStatement.setInt (1 , 1011);  
		callableStatement.setString (2 , "Amit");  
		callableStatement.execute();  
		System.out.println ("Success.");  
	}  
}