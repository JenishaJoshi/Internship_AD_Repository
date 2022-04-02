package com.mastek.demo;
import java.io.*;  
public class BufferedOutputStreamApp 
{
	public static void main (String args []) throws Exception
	{    
	     FileOutputStream fos = new FileOutputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\BufferedOutputStream.txt");    
	     BufferedOutputStream bout = new BufferedOutputStream (fos);    
	     String str = "Welcome To Buffered Output Stream Program.";    
	     byte b[] = str.getBytes();    
	     bout.write (b);    
	     bout.flush();    
	     bout.close();    
	     fos.close();    
	     System.out.println ("Success");    
	}
}