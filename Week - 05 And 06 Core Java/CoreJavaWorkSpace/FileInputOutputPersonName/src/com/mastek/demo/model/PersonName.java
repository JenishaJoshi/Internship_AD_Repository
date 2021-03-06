package com.mastek.demo.model;
import java.util.Objects;
public class PersonName 
{
	private String firstName , lastName;
	public PersonName()
	{
	}
	public PersonName (String firstName , String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName (String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName (String lastName) 
	{
		this.lastName = lastName;
	}
	@Override
	public int hashCode() 
	{
		return Objects.hash(firstName, lastName);
	}
	@Override
	public boolean equals (Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonName other = (PersonName) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}
	@Override
	public String toString() 
	{
		return firstName + " " + lastName;	
	}
}