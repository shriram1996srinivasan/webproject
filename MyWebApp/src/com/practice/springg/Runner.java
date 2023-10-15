package com.practice.springg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner{
	@Autowired
	public static Utill utill;
	
	public int i;
	
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("com/practice/springg/applicationContext.xml");
//		Coach coach = cpx.getBean("baseball",Coach.class);
		Coach coach = utill.getCls("baseball",Coach.class);
//		coach.num=3;
		coach.getFor();
		utill.cpx.close();
//		coach.show1();
//		coach.getFor();
//		cpx.close();
//		cpx.refresh();
//		
//		CricketCoach coach1 = cpx.getBean("myCcoach",CricketCoach.class);
//		System.out.println(coach1.getNum());
//		cpx.close();
	}
	
	public void showw() {
		i=9;
	}
	
	
	
}
