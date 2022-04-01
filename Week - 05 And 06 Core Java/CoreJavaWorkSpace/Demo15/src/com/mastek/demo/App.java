package com.mastek.demo;
import com.mastek.demo.model.Bike;
import com.mastek.demo.model.Book;
import com.mastek.demo.model.Car;
public class App 
{
	public static void main (String [] args) 
	{
		Bike bike = new Bike ("Pulsar" , "Bajaj");
		Book book = new Book ("Gulliver Travel" , "Jonathan Swift");
		Car car = new Car ("Supra" , "Toyota");
		System.out.println (bike);
		System.out.println (book);
		System.out.println (car);
	}
}