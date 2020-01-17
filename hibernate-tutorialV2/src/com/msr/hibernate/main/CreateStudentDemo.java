package com.msr.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.hibernate.demo.entities.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		try {
			Student temp= new Student("tim","tim","tim@msr.com");
			Student temp2= new Student("John","John","John@msr.com");
			Student temp3= new Student("lamb","lamb","lamb@msr.com");
			session.beginTransaction();
			session.save(temp);
			session.save(temp2);
			session.save(temp3);
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
