package com.practice.hackerearth;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Anagrams {

	static boolean isAnagram(String a, String b) {
        // Complete the function
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		Arrays.sort(aa);
		Arrays.sort(bb);
		boolean flag = true;
		for(int i =0;i<aa.length;i++) {
			if(aa[i]!=bb[i]) {
				flag=false;
			}
		}
		return flag;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
	
}
