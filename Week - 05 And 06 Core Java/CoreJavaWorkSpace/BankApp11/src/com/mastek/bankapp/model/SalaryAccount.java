package com.mastek.bankapp.model;
public class SalaryAccount extends SavingAccount 
{
	public SalaryAccount () 
	{
		super ();
		System.out.println ("\nPublic SalaryAccount() Called.");
	}
	public SalaryAccount (int AccountNumber , String AccountName , double Balance)
	{
		super (AccountNumber , AccountName , Balance);
		System.out.println ("\nPublic SalaryAccount (AccountNumber , AccountName , Balance) Called.");
	}
	public SalaryAccount (String AccountName , double Balance)
	{
		super (AccountName , Balance);
		System.out.println ("\nPublic SalaryAccount (AccountName , Balance) Called.");
	}
	@Override
	public String Withdraw (double Amount) 
	{
		if (this.GetBalance() >= Amount)
		{
			this.SetBalance (this.GetBalance() - Amount);
			return this.GetAccountNumber() + " Debited With : " + Amount + ". Current Balance Is : " + this.GetBalance();
		}
		return this.GetAccountNumber() + " Current Balance Is : " + this.GetBalance() + " Try With Another Amount.";
	}
}