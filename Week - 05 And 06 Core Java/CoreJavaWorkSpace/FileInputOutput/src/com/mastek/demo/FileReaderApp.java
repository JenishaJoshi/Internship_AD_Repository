package com.mastek.demo;
import java.io.FileReader;
public class FileReaderApp 
{
	public static void main (String args []) throws Exception
	{    
        FileReader fr = new FileReader ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\FileReader.txt");    
        int i;    
        while ((i = fr.read()) != -1)    
        System.out.print ((char)i);    
        fr.close();    
  }
}