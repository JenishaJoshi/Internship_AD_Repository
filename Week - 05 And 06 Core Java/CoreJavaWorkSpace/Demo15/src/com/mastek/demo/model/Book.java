package com.mastek.demo.model;
public class Book 
{
	private int BookID;
	private String BookName;
	private String AuthorName;
	public Book() 
	{
		super();
	}
	public Book (int BookID , String BookName , String AuthorName) 
	{
		super();
		this.BookID = BookID;
		this.BookName = BookName;
		this.AuthorName = AuthorName;
	}
	public Book (String BookName , String AuthorName) 
	{
		super();
		this.BookName = BookName;
		this.AuthorName = AuthorName;
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
	public String GetAuthorName() 
	{
		return AuthorName;
	}
	public void SetAuthorName (String AuthorName) 
	{
		this.AuthorName = AuthorName;
	}
	@Override
	public String toString() 
	{
		return "Book [ BookID = " + BookID + " , BookName = " + BookName + " , AuthorName = " + AuthorName + " ] ";
	}
}