package com.msr.annotations;

import org.springframework.stereotype.Component;

/*Note- if you don't specify the bean id, then spring will give a default bean id
 which is the class name with first letter in lower-case */
@Component("basketballCoach")
public class BasketballCoach implements Coach{
	
	@Override
	public String getDailyworkout() {
		return "pratice batting for 30mins daily";
	}

}
