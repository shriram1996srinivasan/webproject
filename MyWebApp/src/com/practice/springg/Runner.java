package com.practice.springg;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("com/practice/springg/applicationContext.xml");
		Coach coach = cpx.getBean("mycoach",Coach.class);
		coach.show1();
		coach.getFor();
	}
	
	
	
}
