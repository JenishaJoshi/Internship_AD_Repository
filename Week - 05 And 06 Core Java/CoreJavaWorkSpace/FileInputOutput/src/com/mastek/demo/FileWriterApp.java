package com.mastek.demo;
import java.io.FileWriter;
public class FileWriterApp 
{
	public static void main (String args [])
	{    
        try
        {    
          FileWriter fw = new FileWriter ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\FileWriter.txt");    
          fw.write ("Welcome To File Writer Program.");    
          fw.close();    
        }
        catch (Exception e)
        {
        	System.out.println (e);
        }    
        System.out.println ("Success.");    
    } 
}