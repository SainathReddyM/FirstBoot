package com.msr.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.hibernate.entities.Instructor;
import com.msr.hibernate.entities.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		//create session
		Session session=factory.getCurrentSession();
		
		try {
			//create the objects
			Instructor temp=new Instructor("sai","nath","sainath@msr.com");
			InstructorDetail tempD=new InstructorDetail("youtube/msr","coding");
			//associate the objects
			temp.setInstructorDetail(tempD);
			//start a transaction
			session.beginTransaction();
			//save the instructor
			System.out.println("saving: "+temp.toString());
			session.save(temp);
			//commit transaction
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}
	}

}
