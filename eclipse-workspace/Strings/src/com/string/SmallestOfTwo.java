package com.string;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SmallestOfTwo {
	public static void main(String[] args) {
		List<Integer> list= Arrays.asList(23,12,45,1,7);
		Collections.sort(list);
		System.out.println(list);
		
			System.out.println(list.get(0));
			System.out.println(list.get(1));
		
	}
	
}
