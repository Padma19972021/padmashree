package com.string;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ListProgram {
		public static void main(String[] args) {
			ArrayList<String> cities = new ArrayList<String>();
			Scanner obj=new Scanner(System.in);
			System.out.println(" Input 4 Cities");
			for(int i=0;i<4;i++) {
			
				
				//String cities=obj.next();
				cities.add(obj.next());
				System.out.println(cities);
				StringBuffer newStr=new StringBuffer();  
				for(int j = 0; j < cities.size(); j++) {  
		              
					if(Character.isUpperCase(((CharSequence) cities).charAt(j))) {  
		                //Convert it into upper case using toLowerCase() function  
		                newStr.setCharAt(j, Character.toLowerCase(((CharSequence) cities).charAt(j))); 
		                System.out.println("String after case conversion : " + newStr); 
					}
		                System.out.println("Enter the city");
		                String city=obj.nextLine();
		                if(cities.get(j).contains((CharSequence) city))
		                		System.out.println("found");
		                	
		                	
				/*int len=cities.length();
				for(int j=0;j<len;j++) {
				   char ch=cities.charAt(j);
				   if(Character.isUpperCase(ch)) 
					   System.out.println(Character.toLowerCase(ch.));
					   
				}
			}
		}*/
}
					
				}
				
				 
			}
			
		}

		