package com.mastek.bankapp.model;
public class SavingAccount extends BankAccount 
{
	public SavingAccount() 
	{
		super();
	}
	public SavingAccount (int AccountNumber , String AccountName , double Balance) 
	{
		super(AccountNumber , AccountName , Balance);
	}
	public SavingAccount (String AccountName , double Balance) 
	{
		super(AccountName, Balance);
	}
	@Override
	public String Withdraw (double amount)
	{
		final double difference = this.GetBalance() - amount;
		if (difference >= this.getMinimumBalance())
		{
			this.SetBalance (difference);
			return this.GetAccountName() + "Debited By " + amount + " Current Balanace Is : " + this.GetBalance();
		}
		return this.GetAccountName() + " Current Balance Is : " + this.GetBalance() + " Try Another Amount To Maintain The Minimum Balance Of " + this.getMinimumBalance();
	}
}