package com.msr.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "It's going to be a good day";
	}
}
