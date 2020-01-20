package com.msr.assignment.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msr.assignment.entity.Employee;

public class QueryEmployeeDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Employee> emp = session.createQuery("from Employee s where s.company='tclan'").getResultList();
			for(Employee e: emp) {
				System.out.println(e);
			}
			
		}finally {
			factory.close();
		}
	}

}
