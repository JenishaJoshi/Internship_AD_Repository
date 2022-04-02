package com.mastek.demo;
import java.io.FileInputStream;  
public class FileInputStreamReadSingleCharacterApp 
{
	public static void main (String args [])
	{    
        try
        {    
          FileInputStream fis = new FileInputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\ReadSingleCharacter.txt");    
          int i = fis.read();  
          System.out.print ((char)i);    
          fis.close();    
        }
        catch (Exception e)
        {
        	System.out.println(e);
        }    
    } 
}