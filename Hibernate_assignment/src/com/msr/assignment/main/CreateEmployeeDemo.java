package com.msr.assignment.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.assignment.entity.Employee;

public class CreateEmployeeDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Employee temp= new Employee("sainath","reddy","Tclan");
			Employee temp2= new Employee("tom","tom","Tomclan");
			
			session.save(temp);
			session.save(temp2);
			
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
		
	}

}
