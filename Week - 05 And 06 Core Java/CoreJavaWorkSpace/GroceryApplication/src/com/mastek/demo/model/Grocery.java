package com.mastek.demo.model;
public class Grocery 
{
	private int [] itemsQuantity = {1 , 2 , 3 , 4 , 5 , 6};
	private String [] items = {"Baking Soda" , "Cashews" , "Chocolate Bar" , "Coconut Oil" , "Mangoes" , "Potato Chips"};
	private double [] itemPrice = {40 , 600 , 20 , 120 , 100 , 20};
	private int [] purchaseItem = new int [100];
	private int [] quantityPurchaseItem = new int [100];
	private int counter;
	private double total;
	public void showPurchaseItem() 
	{
		System.out.println ("\nThe Generated Bill Is : ");
		for (int i = 0 ; i < counter ; i++) 
		{
			System.out.println ("\nItem Name Is : " + this.items [this.purchaseItem [i]] + " Quantity Is : " + quantityPurchaseItem[i] + " Price Is : " + this.itemPrice [this.purchaseItem [i]]);
		}
	}
	public double getTotal() 
	{
		return this.total;
	}
	public void generatedBill (int index ,int quantity) 
	{
		index -= 1;
		if (this.itemsQuantity [index] >= quantity)
		{	
			this.total += itemPrice [index] * quantity;
			this.itemsQuantity [index] -= quantity;
			this.purchaseItem [counter] = index;
			this.quantityPurchaseItem [counter++] = quantity;
		}
		else 
		{
			System.out.println ("\"" + this.items [index] + "\" Is Out Of Stock Kindly Select Other Item,");
		}
	}
}