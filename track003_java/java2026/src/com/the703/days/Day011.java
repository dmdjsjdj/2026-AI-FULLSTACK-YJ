package com.the703.days;

import java.util.Scanner;

public class Day011 {

	public static void main(String[] args) {
//		1. if버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
//	    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut
		
			char ch = '\u0000';
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("a,b,c중에 하나를 입력하시오: ");
			ch = scanner.next().charAt(0);
			
			if(ch=='a') {
				System.out.println("apple");
			}
			else if(ch=='b') {
				System.out.println("banana");
			}
			else if(ch=='c') {
				System.out.println("coconut");
			} else { System.out.println("잘못된 입력입니다."); }
			
//		2. switch버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
//		    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut
//	
		    char ch1='\u0000';
		    Scanner scanner1 =new Scanner(System.in);
	
		    System.out.print("a,b,c 중에 입력 > ");  
		    ch1 = scanner1.next().charAt(0);
		    
		    switch(ch1) {
		    case 'a': System.out.println("apple");  break;
		    case 'b': System.out.println("banana");  break;
		    case 'c': System.out.println("coconut");  break;
		    }
//		    
//		3. for, while, do while 버젼으로  문제를 풀으시오!  
//		     1  2  3  4  5
		    System.out.println("for문");
		    for(int i=1; i<=5;i++) {
		    	System.out.print(i+" ");
		    }
		    
		    System.out.println("\nwhile문");
		    int b=1;
		    while( b<=5) {
		    	
		    	System.out.print(b+" ");
		    	b++;
		    }
		    
		    System.out.println("\ndo while문");
		    int c=1;
		    do {
		    	
		    	System.out.print(c+" ");
		    	c++;
		    }while( c<=5);
		    
	}

}
