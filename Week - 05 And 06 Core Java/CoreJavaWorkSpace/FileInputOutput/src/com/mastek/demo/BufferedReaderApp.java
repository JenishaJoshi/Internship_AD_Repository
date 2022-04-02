package com.mastek.demo;
import java.io.*;
public class BufferedReaderApp 
{
	public static void main (String args []) throws Exception
	{    
        FileReader fr = new FileReader ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\BufferedReader.txt");    
        BufferedReader br = new BufferedReader (fr);    
        int i;    
        while ((i = br.read()) != -1){  
        System.out.print ((char)i);  
    }  
    br.close();    
    fr.close();    
  } 
}