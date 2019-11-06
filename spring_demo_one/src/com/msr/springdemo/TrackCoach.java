package com.msr.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "run for 30mins without break";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}
}
