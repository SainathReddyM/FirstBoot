package com.msr.assignment.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.assignment.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								  .configure("hibernate.cfg.xml")
								  .addAnnotatedClass(Employee.class)
								  .buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			session.createQuery("delete from Employee e where e.firstName='tom'").executeUpdate();
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
