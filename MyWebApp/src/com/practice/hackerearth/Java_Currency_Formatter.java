package com.practice.hackerearth;

import java.util.*;
import java.text.*;

public class Java_Currency_Formatter {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        // Write your code here.
        
        NumberFormat num = NumberFormat.getCurrencyInstance();
        num=NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("US: " + num.format(payment));
        DecimalFormat form = new DecimalFormat("#,###.00");
        System.out.println("India: " + "Rs."+form.format(Math.round(payment*100)/100.0));
        //num.setCurrency(Currency.getInstance(Locale.CHINA));
        num=NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println("China: " + num.format(payment));
        num=NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("France: " + num.format(payment));
    }
}
