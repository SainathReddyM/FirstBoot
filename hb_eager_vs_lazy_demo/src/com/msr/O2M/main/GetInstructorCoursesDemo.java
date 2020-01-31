package com.msr.O2M.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.O2M.entities.Course;
import com.msr.O2M.entities.Instructor;
import com.msr.O2M.entities.InstructorDetail;

public class GetInstructorCoursesDemo {

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
			Instructor temp=session.get(Instructor.class, 1);
			System.out.println("Instructor : "+temp);
			System.out.println("Courses : "+temp.getCourses());
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
