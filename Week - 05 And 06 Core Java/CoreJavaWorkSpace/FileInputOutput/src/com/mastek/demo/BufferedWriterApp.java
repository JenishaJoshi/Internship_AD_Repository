package com.mastek.demo;
import java.io.*; 
public class BufferedWriterApp 
{
	public static void main (String [] args) throws Exception 
	{     
	    FileWriter fw = new FileWriter ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\BufferedWriter.txt");  
	    BufferedWriter bw = new BufferedWriter (fw);  
	    bw.write ("Welcome To Buffered Writer Program.");  
	    bw.close();  
	    System.out.println ("Success.");  
	}
}