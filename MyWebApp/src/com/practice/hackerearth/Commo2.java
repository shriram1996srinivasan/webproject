package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bouncycastle.asn1.x509.qualified.TypeOfBiometricData;

public class Commo2{

	
	public static void main(String[] args) {
		Map<String, Integer> mapVal = Map.of("a", 1,"b",2);
		System.out.println(mapVal);
		List<Integer> l = Arrays.asList(1,3,4,2);
//		l = l.stream().filter(i->i>2).collect(Collectors.toList());
		System.out.println(l.toString());
		System.out.println(Stream.iterate(0, e->e+1).limit(100).count());
		int total = l.stream().filter(i->i>1).reduce(0, Integer::sum);
		int max=l.stream().max((i,j)->i>j?1:-1).get();
		int min=l.stream().max((i,j)->i<j?1:-1).get();
		System.out.println(total);
		System.out.println(max);
		System.out.println(min);
		l.stream().forEachOrdered(System.out::println);
		int num1=4;
		int num2=5;
		System.out.println(num1+" "+num2);
//		System.out.println(Stream.iterate(0, i->i+1).limit(3).reduce(4,(sum,4)->sum*4));
	}

//	@Override
//	public boolean show(String d) {
//		// TODO Auto-generated method stub
//		return a.super.show(d);
//	}
}
