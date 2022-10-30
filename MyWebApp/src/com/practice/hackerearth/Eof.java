package com.practice.hackerearth;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

public class Eof {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int i=0;
		while(scan.hasNextLine()) {
			i++;
			String s = scan.nextLine();
			if(s.equals("\n")) {
				break;
			}else {
				System.out.println(i+ " " + s);
			}
		}
	}

}
