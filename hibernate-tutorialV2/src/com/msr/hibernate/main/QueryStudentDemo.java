package com.msr.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.hibernate.demo.entities.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Student> temp=session.createQuery("from Student s where s.email LIKE '%@msr.com'").getResultList();
			for(Student s: temp) {
				System.out.println(s);
			}
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
