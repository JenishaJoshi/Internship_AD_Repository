package com.mastek.demo;
import java.util.Scanner;
import com.mastek.demo.model.Grocery;
import java.lang.Integer;
public class App 
{	
	public static void items() 
	{
		System.out.println ("\n(1). Baking Soda : 15 KG - Rs. 40");
		System.out.println ("\n(2). Cashews : 1 KG - Rs. 600");
		System.out.println ("\n(3). Chocolate Bar : 36 GM - Rs. 20");
		System.out.println ("\n(4). Coconut Oil : 1/2 KG - Rs. 120");
		System.out.println ("\n(5). Mangoes : 1 KG -  Rs. 100");
		System.out.println ("\n(6). Potato Chips : 52 GM - Rs. 20");
	}
	static Scanner scan = new Scanner (System.in);
	public static void main (String[] args) 
	{
		Grocery grocery = new Grocery();
		boolean test = true;
		while (test) 
		{ 
			items();
			String choice;
			System.out.print ("\nEnter Item Number : ");
			choice = scan.nextLine();
			System.out.print ("\nEnter Item Quantity : ");
			int quantity = Integer.parseInt (scan.nextLine());
			if(quantity <= 0) 
			{
				System.out.println ("\nQuantity Cannot Be " + quantity);
				continue;
			}
			switch (choice) 
			{
			case "1" : 
				grocery.generatedBill (1 , quantity);
				break;
			case "2" : 
				grocery.generatedBill (2 , quantity);	
				break;
			case "3" : 
				grocery.generatedBill (3 , quantity);
				break;
			case "4" : 
				grocery.generatedBill (4 , quantity);
				break;
			case "5" : 
				grocery.generatedBill (5 , quantity);
				break;
			case "6" : 
				grocery.generatedBill (6 , quantity);
				break;
			default: 
				System.out.println ("\nChoose Corret Choice.");
			}
			System.out.println ("\nPress \"No\" To Exit Or \"Yes\" To Add More Items");
			choice = scan.nextLine();
			if (choice.equalsIgnoreCase ("No"))
				test = false;
		}
		grocery.showPurchaseItem();
		System.out.println ("\nTotal Amount : " + grocery.getTotal());
	}
}