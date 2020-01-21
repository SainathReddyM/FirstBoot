package com.msr.O2M.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.O2M.entities.Course;
import com.msr.O2M.entities.Instructor;
import com.msr.O2M.entities.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Instructor temp=new Instructor("sainath","reddy","sainath@msr.com");
			InstructorDetail tempD= new InstructorDetail("youtube/msr.com","coding");
			temp.setInstructorDetail(tempD);
			session.save(temp);
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
