package com.mastek.demo;
import java.io.*;
public class SequenceInputStreamReadApp 
{
	public static void main (String args[])throws Exception
	{    
		   FileInputStream fis1 = new FileInputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\SequenceInputStreamRead1.txt");    
		   FileInputStream fis2 = new FileInputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\SequenceInputStreamRead2.txt");    
		   FileOutputStream fos = new FileOutputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\FileWrite.txt");      
		   SequenceInputStream sis = new SequenceInputStream (fis1 , fis2);    
		   int i;    
		   while ((i = sis.read()) != -1)    
		   {    
		     fos.write (i);        
		   }    
		   sis.close();    
		   fos.close();      
		   fis1.close();      
		   fis2.close();       
		   System.out.println ("Success.");  
	} 
}