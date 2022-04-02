package com.mastek.demo;
import java.io.FileOutputStream;  
public class FileOutputStreamWriteStringApp 
{
	public static void main (String args [])
	{    
        try
        {    
          FileOutputStream fos = new FileOutputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\WriteString.txt");    
          String str = "Welcome To File Output Stream Write String Program.";    
          byte b [] = str.getBytes();    
          fos.write (b);    
          fos.close();    
          System.out.println ("Success.");    
        }
        catch (Exception e)
        {
        	System.out.println(e);
        }    
   } 
}