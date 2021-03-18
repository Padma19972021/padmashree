package com.string;

import java.util.ArrayList;
import java.util.Scanner;

public class InputFromUser {
public static void main(String[] args) {
	ArrayList<String> citylist=new ArrayList<>();
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the cities");
	for(int i=0;i<4;i++) {
		citylist.add(s.nextLine().toLowerCase());
		
	}
	System.out.println("citylist" +citylist);
	System.out.println("Enter the city");
	String city=s.nextLine();
	if(citylist.contains(city)) {
		System.out.println("found");
	}
		else {
			System.out.println("not found");
	}
}
}
