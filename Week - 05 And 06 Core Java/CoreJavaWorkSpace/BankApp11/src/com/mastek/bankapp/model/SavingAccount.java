package com.mastek.bankapp.model;
public class SavingAccount extends BankAccount 
{
	private static final double MINIMUM_Balance = 1000.00;
	public SavingAccount() 
	{
		super();
	}
	public SavingAccount (int AccountNumber , String AccountName , double Balance) 
	{
		super (AccountNumber , AccountName , Balance);
	}
	public SavingAccount (String AccountName , double Balance) 
	{
		super(AccountName , Balance);
	}
	@Override
	public String Deposit (double Amount) 
	{
		this.Balance = this.Balance + Amount;
		return Amount + " Credited To " + AccountNumber;
	}
	@Override
	public String Withdraw (double Amount) throws Exception 
	{
		final double Difference = this.Balance - Amount;
		if (Difference >= MINIMUM_Balance)
		{
			this.Balance = Difference;
		}		
		else
		{
			throw new Exception ("\nMaintain Minimum Balance In Account Try Another Amount.");
		}
		return Amount + " Debited To " + AccountNumber;
	}
}