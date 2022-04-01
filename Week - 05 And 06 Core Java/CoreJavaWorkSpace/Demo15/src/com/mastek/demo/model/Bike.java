package com.mastek.demo.model;
public class Bike 
{
	private int BikeID;
	private String BikeName;
	private String Brand;
	public Bike() 
	{
		super();
	}
	public Bike (int BikeID , String BikeName , String Brand) 
	{
		super();
		this.BikeID = BikeID;
		this.BikeName = BikeName;
		this.Brand = Brand;
	}
	public Bike (String BikeName , String Brand) 
	{
		super();
		this.BikeName = BikeName;
		this.Brand = Brand;
	}
	public int GetBikeID() 
	{
		return BikeID;
	}
	public void SetBikeID (int BikeID) 
	{
		this.BikeID = BikeID;
	}
	public String GetBikeName() 
	{
		return BikeName;
	}
	public void SetBikeName (String BikeName) 
	{
		this.BikeName = BikeName;
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
		return " Bike [ BikeID = " + BikeID + " , BikeName = " + BikeName + " , Brand = " + Brand + " ] ";
	}
}