package com.msr.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*Note- if you don't specify the bean id, then spring will give a default bean id
 which is the class name with first letter in lower-case */
@Component("basketballCoach")
public class BasketballCoach implements Coach{
	
	
	private FortuneService fortuneService;
	
	@Value("${name}")
	private String name;
	
	@Autowired
	public BasketballCoach(@Qualifier("happyFortuneService")FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	
	@Override
	public String getDailyworkout() {
		return "pratice batting for 30mins daily";
	}
	
	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	@PostConstruct
	public void startupStuff() {
		// TODO Auto-generated method stub
		System.out.println("inside the postConstruct method");
	}

	@Override
	@PreDestroy
	public void endStuff() {
		// TODO Auto-generated method stub
		System.out.println("inside the predestroy method");
	}

}
