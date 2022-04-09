package com.mastek.demo;
import java.sql.*;
public class PreparedStatementInterfaceApp 
{
	public static void main (String args[])
	{  
		try
		{  
			Class.forName ("oracle.jdbc.driver.OracleDriver");  
		    Connection connection = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe" , "c##ADUser" , "root");  
		    PreparedStatement preparedStatement = connection.prepareStatement ("INSERT INTO Emp values (?,?)");  
		    preparedStatement.setInt (1 , 101); 
		    preparedStatement.setString (2 , "Ratan");  
		    int i = preparedStatement.executeUpdate();  
		    System.out.println (i + " Records Inserted.");
		    preparedStatement = connection.prepareStatement ("UPDATE Emp SET Name = ? WHERE Id = ?");  
		    preparedStatement.setString (1 , "Sonoo"); 
		    preparedStatement.setInt (2 , 101);  
		    i = preparedStatement.executeUpdate();  
		    System.out.println (i + " Records Updated.");
		    preparedStatement = connection.prepareStatement ("DELETE FROM Emp WHERE Id = ?");  
		    preparedStatement.setInt (1 , 101);  
		    i = preparedStatement.executeUpdate();  
		    System.out.println (i + " Records Deleted.");
		    preparedStatement = connection.prepareStatement ("SELECT * FROM Emp");  
		    ResultSet rs = preparedStatement.executeQuery();  
		    while (rs.next())
		    {  
		    	System.out.println (rs.getInt(1) + " " +rs.getString(2));  
		    } 
		    connection.close();  
		}
		catch (Exception e)
		{ 
			System.out.println (e);
		}
	}  
}