package com.msr.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.hibernate.entities.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();

		//create session
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Student student1=session.get(Student.class, 2);
			System.out.println(student1);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
