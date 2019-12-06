package com.msr.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.hibernate.entities.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();

		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			List<Student> theStudents=session.createQuery("from Student s where"+" s.lastName='nath' OR s.firstName='akhil'").getResultList();
			
			for(Student ts: theStudents) {
				System.out.println(ts);
			}
			
			List<Student> theStudents2=session.createQuery("from Student s where"+" s.email LIKE 'sainath%'").getResultList();
			for(Student ts: theStudents2) {
				System.out.println(ts);
			}
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
