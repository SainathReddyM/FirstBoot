package com.msr.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.hibernate.entities.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();

		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			Student ts=session.get(Student.class, 1);
			ts.setFirstName("Sainath");
			ts.setLastName("Reddy");
			
			session.createQuery("update Student s set s.email='Akhil@akhil.com' where s.firstName='akhil'").executeUpdate();
	
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
