package com.practice.springg;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Baseball implements Coach{

	private FortumeService fortune;
	
	public Baseball(FortumeService fs) {
		fortune = fs;
	}
	
	
	public Baseball() {
		// TODO Auto-generated constructor stub
	}


	public void show1() {
		System.out.println("Hello Baseball");
	}


	@Override
	public void getFor() {
		fortune.showFortune();
		
	}
	public void showNum() {
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("com/practice/springg/applicationContext.xml");
		CricketCoach coach1 = cpx.getBean("myCcoach",CricketCoach.class);
		System.out.println(coach1.getNum());
	}
	
}
