package com.msr.O2O.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.O2O.entities.Instructor;
import com.msr.O2O.entities.InstructorDetail;

public class O2OMain {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Instructor.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			InstructorDetail temp= session.get(InstructorDetail.class,1);
			System.out.println(temp);
			System.out.println(temp.getInstructor());
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
