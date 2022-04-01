package com.mastek.bankapp.model;
import java.util.Comparator;
public abstract class BankAccount implements IBankService , Comparable , Comparator
{
	protected int AccountNumber;
	protected String AccountName;
	protected double Balance;
	private static int Counter;
	static 
	{
		Counter = 1001;
	}
	{
		this.AccountNumber = Counter++;
	}
	public BankAccount() 
	{
		super();
	}
	public BankAccount (String AccountName , double Balance) 
	{
		super();
		this.AccountName = AccountName;
		this.Balance = Balance;
	}
	public BankAccount (int AccountNumber , String AccountName , double Balance) 
	{
		super();
		this.AccountNumber = AccountNumber;
		this.AccountName = AccountName;
		this.Balance = Balance;
	}
	public int GetAccountNumber() 
	{
		return AccountNumber;
	}
	public void SetAccountNumber (int AccountNumber) 
	{
		this.AccountNumber = AccountNumber;
	}
	public String GetAccountName() 
	{
		return AccountName;
	}
	public void SetAccountName (String AccountName) 
	{
		this.AccountName = AccountName;
	}
	public double GetBalance() 
	{
		return Balance;
	}
	public void SetBalance (double Balance) 
	{
		this.Balance = Balance;
	}
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + AccountNumber;
		return result;
	}
	@Override
	public boolean equals (Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (AccountNumber != other.AccountNumber)
			return false;
		return true;
	}
	@Override
	public int compareTo (Object o) 
	{
		BankAccount other = (BankAccount) o;
		return this.AccountNumber - other.AccountNumber;
	}
	@Override
	public int compare (Object o1 , Object o2) 
	{
		BankAccount account01 = (BankAccount) o1;
		BankAccount account02 = (BankAccount) o2;
		return account02.AccountNumber - account01.AccountNumber;
	}
	@Override
	public String toString() 
	{
		return "BankAcount [AccountNumber = " + AccountNumber + " , AccountName = " + AccountName + " , Balance = " + Balance + " ] ";
	}	
}