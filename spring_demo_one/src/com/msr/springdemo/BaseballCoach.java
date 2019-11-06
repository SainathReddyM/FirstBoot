package com.msr.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	public String email;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "spend 30mins in batting cage";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
}
