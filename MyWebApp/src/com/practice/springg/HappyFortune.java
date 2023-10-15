package com.practice.springg;

import org.springframework.stereotype.Component;

@Component
public class HappyFortune implements FortumeService {

	@Override
	public void showFortune() {
		System.out.println("have great day");

	}

}
