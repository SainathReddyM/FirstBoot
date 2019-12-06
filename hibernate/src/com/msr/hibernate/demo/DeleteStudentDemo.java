package com.msr.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.hibernate.entities.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();

		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			
			session.createQuery("delete from Student s where s.lastName='e'").executeUpdate();
	
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
