package com.msr.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach=context.getBean("theCoach",Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();
	}

}
