package com.mastek.demo;
import java.io.*; 
public class BufferedInputStreamApp 
{
	public static void main (String args [])
	{    
		  try
		  {    
		    FileInputStream fis = new FileInputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\BufferedInputStream.txt");    
		    BufferedInputStream bis = new BufferedInputStream (fis);    
		    int i;    
		    while ((i=bis.read()) != -1)
		    {    
		     System.out.print ((char)i);    
		    }    
		    bis.close();    
		    fis.close();    
		  }
		  catch (Exception e)
		  {
			  System.out.println(e);
		  }    
	} 
}