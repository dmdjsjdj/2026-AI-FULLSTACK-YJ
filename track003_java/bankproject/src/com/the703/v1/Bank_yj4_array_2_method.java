package com.the703.v1;

import java.util.Arrays;
import java.util.Scanner;

public class Bank_yj4_array_2_method {
		// 변수 0 1 2
		static String[] id = new String[3]; // one two three
		static String[] pw = new String[3]; // 1111 2222 3333
		static double[] balance = new double[3];// 1100 2200 3300
		static int menu = -1;
		static Scanner sc = new Scanner(System.in);
		static int inputm = -1, outputm = -1;
		static char deletid = '\u0000';
		static String id2 = " ";
		static String pw2 = " ";
		static int find=-1;
		
	    //2. 유저 빈칸찾기 기능, 3. 사용자인증기능 (아이디와 비밀번호가 같은지 찾기)
		public static int fd() {
            for (int i = 0; i < id.length; i++) {
            	find=-1;
            	if(menu==1) {
            		if (balance[i] == 0) { find = i; break;}
            		else { find=-1;  break;}
            	}
            	else if(menu >= 2 && menu <= 6) {
            		if (id[i].equals(id2) && pw[i].equals(pw2)) { find = i;  break;}
            		else { find=-1; break;}
            	}
            	
            }System.out.println(find);
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
	        pw[f] = sc.next();
            return pw[f];
		}
		public static double bal(int f) {
			do {
	            System.out.print("잔액: ");
	            balance[f] = sc.nextInt();
	         } while (balance[f] < 0);
            return balance[f];
		}
			
		
		
	    //5. 조회기능
		public static void balance(int f) {
			System.out.println("잔액: "+balance[f]+"원");
		}
		
	    //6. 입금기능, 7. 출금기능
		public static void money(int a, String b,int f) {
			if( "in".equals(b)) {
				if (inputm >= 0) {
		            balance[f] = balance[f] + (double) inputm;
		            System.out.println( "잔액: " + balance[f] + "원");
		         } else {
		        	 System.out.println( "음수는 입력할 수 없습니다");
		         }
			}
			else if("out".equals(b)) {
				if (outputm >= 0 && balance[f] - (double) outputm >= 0) {
		            balance[f] = balance[f] - (double) outputm;
		            System.out.println("잔액: " + balance[f] + "원");
		         } else {
		            System.out.println("잔액이 부족합니다.\n  현재 잔액" + balance[f]+"원");
		         }
			}
			return;
		}
	    //8. 삭제기능
		public static String del(char ch,int f) {
			String a=" ";
			if (deletid == 'y' || deletid == 'Y') {
				a= "null";
	         } else if (deletid == 'n' || deletid == 'N') {
	            a="삭제 취소";
	         }
			return a;
		}
		
		
		
   public static void main(String[] args) {
      //  public static 리턴값 메서드명(재료) 

      System.out.print("\n 🌟💰 welcome to bank 💰🌟\r\n");

      while (menu != 9) {
    	 // 
         System.out.println(Arrays.toString(id));
         System.out.println(Arrays.toString(pw));
         System.out.print("\n -- bank menu --\r\n" + "\r\n" + "1.➕계좌 추가\r\n" + "2.🔍계좌 조회\r\n" + "3.💵입금\r\n"
               + "4.💸 출금\r\n" + "5.🗑️삭제\r\n" + "6.🔧비번 수정\r\n" + "9.종료\r\n" + "\r\n" + "👉 번호를 선택하세요: ");

         menu = sc.nextInt();
         //   public static 번호 menu(){} 

         if (menu == 9) { // 9.종료 >> 종료합니다.
            System.out.println("종료합니다.");
         } else if (menu == 1) { // 1.추가 - 아이디 id, 비번 pw, 잔액 balance
            
            //기능1 - 빈칸찾기
            int find = fd();
            if(find==-1) {System.out.println("가입불가"); continue;}
            
            //기능2 - 빈칸이 있다면 입력받기
            id(find);
            pw(find);
            bal(find);
         } 
         else if (menu >= 2 && menu <= 6) {
            System.out.print("아이디: ");
            id2 = sc.next();
            System.out.print("비밀번호: ");
            pw2 = sc.next();

            int find = fd();
            if(find==-1) {System.out.println("정보확인해주세요.");}
            
	          switch (menu) {
	          case 2:
	             bal(find);
	             break;
	
	          case 3:
	             System.out.print("입금금액: ");
	             inputm = sc.nextInt();
	
	             String in = "in";
				money(inputm,in,find);
	             break;
	
	          case 4:
	             System.out.print("출금금액: ");
	             outputm = sc.nextInt();
	
	             String out = "out";
				money(outputm,out,find);
	             break;
	
	          case 5:
	             System.out.print("계좌를 삭제하시겠습니까?( y / n ): ");
	             deletid = sc.next().charAt(0);
	
	             if(del(deletid,find).equals(null)) {
	            	 id[find]=null;
		             pw[find]=null;
		             balance[find]=-1;
		             break;
	             }
	             else {
	            	 System.out.println(del(deletid,find));
	             }
	             break;
	
	          case 6:
	             System.out.print("변경할 비밀번호: ");
	             pw2 = sc.next();
	
	             pw[find] = pw2;
	
	             break;
	
	          default:
	             System.out.println("잘못된 숫자입력입니다.");
	             break;
	          };
            

         } else {
            System.out.println("\n 잘못된 입력입니다.");
         }
      }

   }

}