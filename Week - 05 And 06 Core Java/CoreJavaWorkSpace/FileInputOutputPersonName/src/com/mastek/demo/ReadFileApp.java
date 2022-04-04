package com.mastek.demo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.mastek.demo.model.PersonName;
public class ReadFileApp 
{
	public static void main (String [] args) throws IOException , FileNotFoundException 
	{
		File file = new File ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\PersonName.txt");
		BufferedReader br = new BufferedReader (new FileReader (file));
		int noOfPersons = Integer.parseInt (br.readLine());
		PersonName persons [] = new PersonName [noOfPersons];
		String str;
		int i = 0;
		while ((str=br.readLine()) != null) 
		{
			if (i == noOfPersons) break;
			String [] personName = str.split (":");
			persons [i] = new PersonName (personName [0] , personName[1]);
			i++;
		}
		br.close();
		for (PersonName object : persons) 
		{
			System.out.println (object.toString());
		}
	}
}