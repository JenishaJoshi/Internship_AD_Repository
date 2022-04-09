package com.training.demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.training.demo.model.Person;
public class App 
{
	public static void main (String [] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext ("bean.xml");
		Person person = context.getBean (Person.class);
		System.out.println (person);
	}
}