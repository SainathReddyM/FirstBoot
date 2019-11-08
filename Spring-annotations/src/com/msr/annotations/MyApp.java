package com.msr.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach=context.getBean("basketballCoach",Coach.class);
		
		System.out.println(theCoach.getDailyworkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getName());
		
		context.close();
	}

}
