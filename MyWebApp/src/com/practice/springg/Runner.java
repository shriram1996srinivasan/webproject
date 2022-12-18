package com.practice.springg;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("com/practice/springg/applicationContext.xml");
		CricketCoach coach = cpx.getBean("myCcoach",CricketCoach.class);
		coach.num=3;
		System.out.println(coach.getNum());
		coach.show1();
		coach.getFor();
		cpx.close();
		cpx.refresh();
		
		CricketCoach coach1 = cpx.getBean("myCcoach",CricketCoach.class);
		System.out.println(coach1.getNum());
		cpx.close();
	}
	
	
	
}
