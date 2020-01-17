package com.msr.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.hibernate.demo.entities.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Student temp= session.get(Student.class, 1);
			Student temp2= session.get(Student.class, 3);
			System.out.println(temp);
			System.out.println(temp2);
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
