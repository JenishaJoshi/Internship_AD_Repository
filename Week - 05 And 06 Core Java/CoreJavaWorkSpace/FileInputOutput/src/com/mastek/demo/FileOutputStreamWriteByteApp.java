package com.mastek.demo;
import java.io.FileOutputStream;
public class FileOutputStreamWriteByteApp 
{
	public static void main (String args [])
	{    
        try
        {    
          FileOutputStream fos = new FileOutputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\WriteByte.txt");    
          fos.write (65);    
          fos.close();    
          System.out.println ("Success.");    
        }
        catch (Exception e)
        {
        	System.out.println (e);
        }    
   }    
}