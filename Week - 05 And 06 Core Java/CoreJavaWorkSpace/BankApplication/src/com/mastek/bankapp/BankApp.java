package com.mastek.bankapp;
import java.util.Scanner;
import com.mastek.bankapp.model.BankAccount;
import com.mastek.bankapp.model.SavingAccount;
public class BankApp 
{
	private static Scanner scan = new Scanner (System.in);
	private static BankAccount accounts [] = new BankAccount [10];
	private static int counter;
	public static void main (String [] args) 
	{
		boolean test = true;
		while (test)
		{
			System.out.println ("\nDo You Want To Open Bank Account ? : ");
			String choice = scan.nextLine();
			if (choice.equalsIgnoreCase("Yes"))
			{
				System.out.println ("\nWhich Type Of Account Do You Want To Open ? : ");
				System.out.println ("1. Savings Account.");
				System.out.println ("2. Salary Account.");
				int account = Integer.parseInt (scan.nextLine());
				switch (account)
				{
					case 1 : 
						openSavingsAccount();
						break;
					case 2 : 
						openSalaryAccount();
						break;
					default :
						break;
				}
			}
			else
				test = false;
		}
	}
	public static void openSavingsAccount()
	{
		System.out.println ("1. Minuimim Balance Is : 1000.");
		System.out.println ("2. Minuimim Balance Is : 10000.");
		int balance = Integer.parseInt (scan.nextLine());
		System.out.println ("\nEnter Your Name : ");
		String AccountName = scan.nextLine();
		System.out.println ("\nEnter Appropriate Balance : ");
		int Balance = Integer.parseInt (scan.nextLine());
		accounts [counter] = new SavingAccount (AccountName , Balance);
		if (balance == 1 & Balance > 1000)
		{
			System.out.println ("\nYour Account Details Is : ");
			System.out.println ("\nAccount Number : " + accounts [counter].GetAccountNumber());
			System.out.println ("\nAccount Name : " + accounts [counter].GetAccountName());
			System.out.println ("\nAccount Balance : " + accounts [counter].GetBalance());
			counter++;
		}
		else if (balance == 2 & Balance > 10000)
		{
			System.out.println ("\nYour Account Details Is : ");
			System.out.println ("\nAccount Number : " + accounts [counter].GetAccountNumber());
			System.out.println ("\nAccount Name : " + accounts [counter].GetAccountName());
			System.out.println ("\nAccount Balance : " + accounts [counter].GetBalance());
			counter++;
		}
		else
		{
			System.out.println ("\nEnter Appropriate Amount Either Of Rs. 1000 Or Of Rs. 10000.");
		}
		
	}
	public static void openSalaryAccount()
	{
		System.out.println ("\nEnter Your Name : ");
		String AccountName = scan.nextLine();
		System.out.println ("\nEnter Appropriate Balance : ");
		double Balance = Double.parseDouble (scan.nextLine());
		accounts [counter] = new SavingAccount (AccountName , Balance);
		System.out.println ("\nYour Account Details Is : ");
		System.out.println ("\nAccount Number : " + accounts [counter].GetAccountNumber());
		System.out.println ("\nAccount Name : " + accounts [counter].GetAccountName());
		System.out.println ("\nAccount Balance : " + accounts [counter].GetBalance());
		counter++;
	}
}