package com.mastek.demo;
import java.io.FileInputStream;  
public class FileInputStreamReadAllCharactersApp 
{
	public static void main (String args [])
	{    
        try
        {    
          FileInputStream fis = new FileInputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\ReadAllCharacters.txt");    
          int i = 0;    
          while ((i = fis.read()) != -1)
          {    
           System.out.print ((char)i);    
          }    
          fis.close();    
        }
        catch (Exception e) 
        {
        	System.out.println(e);
        }    
	}
}