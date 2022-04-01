package com.mastek.bankapp.model;
public abstract class BankAccount extends Object
{
	private int AccountNumber;
	private String AccountName;
	private double Balance;
	private static int Counter = 1001;
	private int minimumBalance;
	public BankAccount()
	{
		this.AccountNumber = Counter++;
	}
	public BankAccount (String AccountName , double Balance)
	{
		this();
		this.AccountName = AccountName;
		this.Balance = Balance;
	}
	public BankAccount (int AccountNumber , String AccountName , double Balance)
	{
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
	public String Deposit (double Amount) 
	{
		this.Balance = this.Balance + Amount;
		return this.AccountNumber + " Credited With : " + Amount + ". Current Balance Is : " + this.Balance;
	}
	public int getMinimumBalance()
	{
		return minimumBalance;
	}
	public abstract String Withdraw (double amount);
}