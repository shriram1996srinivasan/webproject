package com.practice.springg;

public class Baseball implements Coach{

	private FortumeService fortune;
	
	public Baseball(FortumeService fs) {
		fortune = fs;
	}
	
	
	public void show1() {
		System.out.println("Hello Baseball");
	}


	@Override
	public void getFor() {
		fortune.showFortune();
		
	}
	
}
