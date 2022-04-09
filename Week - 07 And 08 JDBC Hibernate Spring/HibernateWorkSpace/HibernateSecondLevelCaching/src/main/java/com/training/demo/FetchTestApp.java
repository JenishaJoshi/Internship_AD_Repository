package com.training.demo;
import org.hibernate.Session;    
import org.hibernate.SessionFactory;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.training.demo.model.Employee;
public class FetchTestApp 
{
	public static void main(String[] args) 
	{    
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure ("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	    SessionFactory factory = meta.getSessionFactoryBuilder().build();
	    Session session1 = factory.openSession();    
	    Employee employee1 = (Employee) session1.load (Employee.class , 121);    
	    System.out.println (employee1.getId() + " " + employee1.getName() + " " + employee1.getSalary());    
	    session1.close();    
	    Session session2 = factory.openSession();    
	    Employee employee2 = (Employee) session2.load (Employee.class , 121);    
	    System.out.println (employee2.getId() + " " + employee2.getName() + " " + employee2.getSalary());    
	    session2.close();    
	}
}