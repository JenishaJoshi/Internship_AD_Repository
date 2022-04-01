package com.mastek.demo.model;
public class Car 
{
	private int CarID;
	private String CarName;
	private String Brand;
	public Car() 
	{
		super();
	}
	public Car (int CarID , String CarName , String Brand) 
	{
		super();
		this.CarID = CarID;
		this.CarName = CarName;
		this.Brand = Brand;
	}
	public Car(String CarName , String Brand) 
	{
		super();
		this.CarName = CarName;
		this.Brand = Brand;
	}
	public int GetCarID() 
	{
		return CarID;
	}
	public void SetCarID (int CarID) 
	{
		this.CarID = CarID;
	}
	public String GetCarName() 
	{
		return CarName;
	}
	public void SetCarName (String CarName) 
	{
		this.CarName = CarName;
	}
	public String GetBrand() 
	{
		return Brand;
	}
	public void SetBrand (String Brand) 
	{
		this.Brand = Brand;
	}
	@Override
	public String toString() 
	{
		return " Car [ CarID = " + CarID + " , CarName = " + CarName + " , Brand = " + Brand + " ] ";
	}
}