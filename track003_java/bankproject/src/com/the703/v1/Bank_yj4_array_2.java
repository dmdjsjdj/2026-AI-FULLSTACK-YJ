package com.the703.v1;

import java.util.Arrays;
import java.util.Scanner;

public class Bank_yj4_array_2 {

   public static void main(String[] args) {
      // 변수 0 1 2
      String[] id = new String[3]; // one two three
      String[] pw = new String[3]; // 1111 2222 3333
      double[] balance = new double[3];// 1100 2200 3300
      int menu = -1;
      Scanner scanner = new Scanner(System.in);
      int inputm = -1, outputm = -1;
      char deletid = '\u0000';
      String id2 = " ";
      String pw2 = " ";

      Scanner sc = new Scanner(System.in);

      System.out.print("\n 🌟💰 welcome to bank 💰🌟\r\n");

      while (menu != 9) {
         System.out.println(Arrays.toString(id));
         System.out.println(Arrays.toString(pw));
         System.out.print("\n -- bank menu --\r\n" + "\r\n" + "1.➕계좌 추가\r\n" + "2.🔍계좌 조회\r\n" + "3.💵입금\r\n"
               + "4.💸 출금\r\n" + "5.🗑️삭제\r\n" + "6.🔧비번 수정\r\n" + "9.종료\r\n" + "\r\n" + "👉 번호를 선택하세요: ");

         menu = sc.nextInt();
         

         if (menu == 9) { // 9.종료 >> 종료합니다.
            System.out.println("종료합니다.");
         } else if (menu == 1) { // 1.추가 - 아이디 id, 비번 pw, 잔액 balance
            
            //기능1 - 빈칸찾기
            int find=-1;
            for (int i = 0; i < id.length; i++) {
               if (id[i] == null) { find = i; break; }
            }
            //기능2 - 빈칸이 있다면 입력받기
            System.out.print("아이디: ");
            id[find] = sc.next();
            System.out.print("비밀번호: ");
            pw[find] = sc.next();
            do {
               System.out.print("잔액: ");
               balance[find] = sc.nextInt();
            } while (balance[find] < 0);
         } 
         else if (menu >= 2 && menu <= 6) {
            System.out.print("아이디: ");
            id2 = sc.next();
            System.out.print("비밀번호: ");
            pw2 = sc.next();

            int find=-1;
            for (int i = 0; i < id.length; i++) {
            	if (id[i].equals(id2) && pw[i].equals(pw2)) { find = i; break; }
            }
            
	          switch (menu) {
	          case 2:
	             System.out.println("잔액: " + balance[find] + "원");
	             break;
	
	          case 3:
	             System.out.print("입금금액: ");
	             inputm = sc.nextInt();
	
	             if (inputm >= 0) {
	                balance[find] = balance[find] + (double) inputm;
	                System.out.println("잔액: " + balance[find] + "원");
	             } else {
	                System.out.println("음수는 입력할 수 없습니다");
	             }
	             break;
	
	          case 4:
	             System.out.print("출금금액: ");
	             outputm = sc.nextInt();
	
	             if (outputm >= 0 && balance[find] - (double) outputm >= 0) {
	                balance[find] = balance[find] - (double) outputm;
	                System.out.println("잔액: " + balance[find] + "원");
	             } else {
	                System.out.println("잔액이 부족합니다.  현재 잔액" + balance[find]);
	             }
	             break;
	
	          case 5:
	             System.out.print("계좌를 삭제하시겠습니까?: ( y / n ) ");
	             deletid = sc.next().charAt(0);
	
	             if (deletid == 'y') {
	                System.out.println("계좌가 삭제되었습니다.");
	                id[find] = null;
	                pw[find] = null;
	             } else if (deletid == 'n') {
	                System.out.println("계좌 삭제를 취소하셨습니다.");
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