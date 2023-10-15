package com.practice.springg;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Baseball implements Coach{
	@Autowired
	private FortumeService happyFortune;
//	@Autowired
//	public Baseball(FortumeService fs) {
//		fortune = fs;
//	}
	
	@Value("${cricket_captain}")
	public String cricket_captain;
	public Baseball() {
		// TODO Auto-generated constructor stub
	}


	public void show1() {
		System.out.println("Hello Baseball");
	}


	@Override
	public void getFor() {
		happyFortune.showFortune();
		
	}
	@Autowired
	public void show() {
		System.out.println("inside show");
	}
	
//	@PostConstruct
	public void startup() {
		System.out.println("Startingggg!!!");
		System.out.println(cricket_captain);
	}
	
//	@PreDestroy
	public void endup() {
		System.out.println("endingggggg!!!!");
	}
	/*
	 * public void showNum() { ClassPathXmlApplicationContext cpx = new
	 * ClassPathXmlApplicationContext("com/practice/springg/applicationContext.xml")
	 * ; CricketCoach coach1 = cpx.getBean("myCcoach",CricketCoach.class);
	 * System.out.println(coach1.getNum()); }
	 */
	
}
