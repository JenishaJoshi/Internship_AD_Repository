package com.mastek.demo;
import java.io.*;
public class SequenceInputStreamPrintApp 
{
	public static void main (String args []) throws Exception
	{    
		   FileInputStream fis1 = new FileInputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\SequenceInputStreamPrint1.txt");    
		   FileInputStream fis2 = new FileInputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\SequenceInputStreamPrint2.txt");    
		   SequenceInputStream sis = new SequenceInputStream (fis1 , fis2);    
		   int i;    
		   while((i = sis.read()) != -1)
		   {    
			   System.out.print ((char)i);    
		   }    
		   sis.close();    
		   fis1.close();    
		   fis2.close();    
	}
}