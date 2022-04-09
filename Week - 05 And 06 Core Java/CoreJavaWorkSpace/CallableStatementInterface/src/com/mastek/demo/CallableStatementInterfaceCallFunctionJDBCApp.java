package com.mastek.demo;
import java.sql.*;
public class CallableStatementInterfaceCallFunctionJDBCApp 
{
	public static void main (String[] args) throws Exception
	{  	  
		Class.forName ("oracle.jdbc.driver.OracleDriver");  
		Connection connection = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe" , "c##ADUser" , "root");  
		CallableStatement callableStatement = connection.prepareCall ("{? = call SumTotal (? , ?)}");  
		callableStatement.setInt (2,10);  
		callableStatement.setInt (3,43);  
		callableStatement.registerOutParameter (1 , Types.INTEGER);  
		callableStatement.execute();  
		System.out.println (callableStatement.getInt (1));        
	}
}