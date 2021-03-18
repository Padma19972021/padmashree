


	package com.string;

	import java.util.Scanner;
	import java.util.ArrayList;
	//import java.util.List;

	public class List {
			public static void main(String[] args) {
				//ArrayList<String> cities = new ArrayList<String>();
				Scanner obj=new Scanner(System.in);
				System.out.println(" Input 4 Cities");
				for(int i=0;i<4;i++) {
				
					
					String cities=obj.next();
					//cities.add(obj.next());
					System.out.println(cities);
					StringBuffer newStr=new StringBuffer(cities);  
					for(int j = 0; j < cities.length(); j++) {  
			              
						if(Character.isUpperCase( newStr.charAt(j))) {  
			                //Convert it into upper case using toLowerCase() function  
							newStr.setCharAt(j, Character.toLowerCase(newStr.charAt(j))); 
			                System.out.println("String after case conversion : " + newStr); 
			              //if(cities.get(j).contains( cities))
			                
			                		//System.out.println("found");
			                	
			                	
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
	}

			

