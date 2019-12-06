package com.msr.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.hibernate.entities.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();

		//create session
		Session session=factory.getCurrentSession();
		
		try {
			Student student1=new Student("akhil","b","akhil@test.com");
			Student student2=new Student("balaji","e","balaji@test.com");
			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}
	}

}
