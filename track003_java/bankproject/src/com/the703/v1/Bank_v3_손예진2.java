package com.the703.v1;

import java.util.Arrays;
import java.util.Scanner;

class Steel {

	// 변수 0 1 2
	static String[] id = new String[3]; // one two three
	static String[] pass = new String[3]; // 1111 2222 3333
	static double[] balance = new double[3];// 1100 2200 3300
	
	static Scanner sc = new Scanner(System.in);
	static char deletid = '\u0000';
	static String id2 = " ";
	static String pw2 = " ";
	static int tempbalance = -1;
	
	//		   1. 메뉴 선택
	public static int menu() {
		System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
	               + "[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제  [9]종료\r\n"
	               + "👉 번호를 선택하세요:");
	         int menu = sc.nextInt();
	         return menu;
	}
	//		   2. 기능 
	// 유저 빈칸찾기 기능, 3. 사용자인증기능 (아이디와 비밀번호가 같은지 찾기)
	public static int fd(int m) {
		int find = -1;
        for (int i = 0; i < id.length; i++) {
        	if(m==1) {
        		if (id[i] == null)  
        			return find = i;  
        	}
        	else if(m >= 2 && m <= 6) {
        	//   2-1. 사용자가 맞는지 여부
	            String id2="-1", pw2="-1"; 
	            System.out.print("아이디  입력 > ");   id2 = sc.next();
	            System.out.print("비밀번호 입력 > ");   pw2 = sc.next(); 
        		if (id[i].equals(id2) && pass[i].equals(pw2))   find = i; 
        		
        		return find;
        	}
           
        }
        return find;
	}
	//4. 계좌추가기능
	public static String id(int f) {
		System.out.print("아이디: ");
        id[f] = sc.next();
        return id[f];
	}
	public static String pw(int f) {
		System.out.print("비밀번호: ");
        pass[f] = sc.next();
        return pass[f];
	}
	public static double bal(int f) {
		do {
            System.out.print("잔액: ");
            balance[f] = sc.nextInt();
         } while (balance[f] < 0);
        return balance[f];
	}
	
}
public class Bank_v3_손예진2 {
	   public static void main(String[] args) {
		   	int menu = -1;
			int find = -1;
			
		   
		   //for(   ;menu!=9;   ) {
		      while(menu!=9) {
		    	  System.out.println(Arrays.toString(Steel.id));
		          System.out.println(Arrays.toString(Steel.pass));
		          System.out.println(Arrays.toString(Steel.balance));
//		            System.out.println( id + "\t" + pass + "\t" + balance);  // 계좌의 1명분  확인용
		          menu  = Steel.menu();
		         
		         if (menu == 9) {
		            System.out.println("프로그램을 종료합니다.");
		         } else if (menu == 1) {

		            find = Steel.fd(menu);
		            // 꽉찼을경우 
		            if(find == -1) { System.out.println("가입불가!"); continue;  } 

		          //기능2 - 빈칸이 있다면 입력받기
		            Steel.id(find);
		            Steel.pw(find);
		            Steel.bal(find);
		            
		         }else if (menu >= 2 && menu <= 5) { 
		            
		            
		        	 find = Steel.fd(menu);
		   
		            if(  find==-1 ) { 
		               System.out.println("정보확인해주세요.");  continue; 
		            }
		            
		            Scanner sc = new Scanner(System.in);
					switch( menu ){
		            case 2 : System.out.printf("ID : %s\nPASS: %s\nBALANCE: %.2f\n" ,Steel.id[find] ,Steel.pass[find] , Steel.balance[find]);     break;
		            case 3 : System.out.print("입금할 금액 > ");  Steel.tempbalance = sc.nextInt();       
		                     System.out.println("입금완료! 현재잔액 : " + (Steel.balance[find] += Steel.tempbalance));
		            
		            break;
		            case 4 :  
		               System.out.print("출금할 금액 > ");   Steel.tempbalance = sc.nextInt();  
		               System.out.println( Steel.tempbalance > Steel.balance[find] ?"잔액부족! 출금불가" : "출금완료! 현재잔액 : " + (Steel.balance[find] -= Steel.tempbalance));
		            break;
		            case 5 : System.out.print("계좌삭제 (Y/N) > "); char again = sc.next().charAt(0);
		               if(again == 'Y' || again == 'y') { Steel.id[find] = null; Steel.pass[find] = null; Steel.balance[find] = -1;
		               									System.out.println("계좌가 삭제되었습니다.");}
		            break;
					}
		            
		         }
		      }// end while       
	   }

}