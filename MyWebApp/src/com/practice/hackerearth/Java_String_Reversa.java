package com.practice.hackerearth;

import java.io.*;
import java.util.*;

public class Java_String_Reversa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		/* Enter your code here. Print output to STDOUT. */
        int i=0;
        StringBuilder B = new StringBuilder(A);
        if(A.equals(B.reverse().toString())){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
//		boolean flag = false;
//		if (A.length() % 2 != 0) {
//			for (int i = 0; i < A.length(); i++) {
//				if ((A.length() / 2) + 1 == i) {
//					if (A.charAt(i) == (A.charAt(A.length() - 1))) {
//						flag = true;
//					} else {
//						flag = false;
//					}
//				}
//			}
//		} else {
//			for (int i = 0; i < A.length(); i++) {
//				if (A.charAt(i) == (A.charAt(A.length() - 1))) {
//					flag = true;
//				}else {
//					flag = false;
//				}
//			}
//		}
//		if(!flag) {
//			System.out.println("Yes");
//		}else {
//			System.out.println("No");
//		}
	}
}
