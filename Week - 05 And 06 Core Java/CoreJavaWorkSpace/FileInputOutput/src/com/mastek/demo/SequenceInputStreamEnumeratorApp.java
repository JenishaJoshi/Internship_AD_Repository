package com.mastek.demo;
import java.io.*;    
import java.util.*; 
public class SequenceInputStreamEnumeratorApp 
{
	public static void main (String args []) throws IOException
	{    
		FileInputStream fis1 = new FileInputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\SequenceInputStreamEnumerator1.txt");    
		FileInputStream fis2 = new FileInputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\SequenceInputStreamEnumerator2.txt");    
		FileInputStream fis3 = new FileInputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\SequenceInputStreamEnumerator3.txt");    
		FileInputStream fis4 = new FileInputStream ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\SequenceInputStreamEnumerator4.txt");    
		Vector vect = new Vector();    
		vect.add (fis1);    
		vect.add (fis2);    
		vect.add (fis3);    
		vect.add (fis4);              
		Enumeration e = vect.elements();      
		SequenceInputStream sis = new SequenceInputStream (e);    
		int i = 0;      
		while ((i = sis.read()) != -1)
		{    
			System.out.print ((char)i);    
		}     
		sis.close();    
		fis1.close();    
		fis2.close();    
	}    
}