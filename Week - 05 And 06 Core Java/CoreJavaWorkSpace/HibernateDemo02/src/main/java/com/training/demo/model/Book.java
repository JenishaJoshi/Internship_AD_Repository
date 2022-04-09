package com.training.demo.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ADBook")
public class Book 
{
	@Id
	private int BookID;
	private String BookName;
	public Book () 
	{
		super();
	}
	public Book (int BookID , String BookName) 
	{
		super();
		this.BookID = BookID;
		this.BookName = BookName;
	}
	public Book (String BookName) 
	{
		super();
		this.BookName = BookName;
	}
	public int GetBookID() 
	{
		return BookID;
	}
	public void SetBookID (int BookID) 
	{
		this.BookID = BookID;
	}
	public String GetBookName() 
	{
		return BookName;
	}
	public void SetBookName (String BookName) 
	{
		this.BookName = BookName;
	}
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + BookID;
		return result;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (BookID != other.BookID)
			return false;
		return true;
	}
	@Override
	public String toString() 
	{
		return "Book [ BookID = " + BookID + " , BookName = " + BookName + " ] ";
	}
}