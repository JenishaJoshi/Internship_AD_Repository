package com.mastek.bankapp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import com.mastek.bankapp.model.BankAccount;
import com.mastek.bankapp.model.SalaryAccount;
import com.mastek.bankapp.model.SavingAccount;
public class BankApp 
{
	private static void Display (Set <BankAccount> AccountSet) 
	{
		for (BankAccount Account : AccountSet) 
		{
			System.out.println (Account);
		}
	}
	public static void main (String []  args) 
	{
		Set <BankAccount> AccountSet = new TreeSet <>();
		AccountSet.add (new SavingAccount ("Jenisha" , 10000));
		AccountSet.add (new SavingAccount ("Jeni" , 11000));
		AccountSet.add (new SavingAccount ("JJ" , 12000));
		System.out.println ("\nNatural Order Using Comparable : ");
		Display (AccountSet);
		System.out.println ("\nNatural Order Using Comparator : ");
		List <BankAccount> BankList = new ArrayList <>();
		Comparator comparator = new Comparator<BankAccount>() {

			@Override
			public int compare(BankAccount o1, BankAccount o2) {
				return o2.GetAccountNumber() - o1.GetAccountNumber();
			}
		};
		BankList.add (new SavingAccount ("Jenisha" , 10000));
		BankList.add (new SavingAccount ("Jeni" , 11000));
		BankList.add (new SavingAccount ("JJ" , 12000));
		BankList.sort (comparator);
		for (BankAccount Account : BankList) 
		{
			System.out.println (Account);
		}
	}
}