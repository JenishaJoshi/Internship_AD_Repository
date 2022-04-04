package com.mastek.demo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class WriteFileApp  
{
	public static void main (String [] args) throws IOException 
	{
		File file = new File ("D:\\Training 2022\\Week - 05 And 06 Core Java\\CoreJavaWorkSpace\\PersonName.txt");
		FileWriter fw = new FileWriter (file);
		Scanner scan = new Scanner (System.in);
		System.out.println ("How Many Names Do You Want To Enter ? : ");
		int numberOfPersons;
		numberOfPersons = Integer.parseInt (scan.nextLine());
		String firstName , lastName;
		fw.write ("There Are Total " + numberOfPersons + " Person Names.\n\n");
		for (int i = 0 ; i < numberOfPersons ; i++)
		{	
			System.out.println("Enter First Name : ");
			firstName = scan.nextLine();
			System.out.println ("Enter Last Name : ");
			lastName = scan.nextLine();
			fw.write (firstName + ":" + lastName + "\n\n");
		}
		fw.close();
		scan.close();
		System.out.println ("Writing In A File Is Successful.");
	}
}