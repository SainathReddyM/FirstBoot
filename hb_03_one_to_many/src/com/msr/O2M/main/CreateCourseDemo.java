package com.msr.O2M.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.O2M.entities.Course;
import com.msr.O2M.entities.Instructor;
import com.msr.O2M.entities.InstructorDetail;

public class CreateCourseDemo {

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
			Course tc1= new Course("java full stack");
			Course tc2= new Course("python full stack");
			Course tc3= new Course("Javascript");
			Instructor temp= session.get(Instructor.class, 1);
			temp.addCourse(tc1);
			temp.addCourse(tc2);
			temp.addCourse(tc3);
			session.save(tc1);
			session.save(tc2);
			session.save(tc3);
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
