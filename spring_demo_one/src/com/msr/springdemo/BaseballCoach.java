package com.msr.springdemo;

public class BaseballCoach implements Coach {
	
	@Override
	public String getDailyWorkout() {
		return "spend 30mins in batting cage";
	}
}
