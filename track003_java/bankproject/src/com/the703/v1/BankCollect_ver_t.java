package com.the703.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//1. Dto 데이터전송목적
class BankDto2{
   private String id;
   private String pass;
   private double balance;
   
   @Override public int hashCode() { return Objects.hash(id); }
   @Override public boolean equals(Object obj) { 
	   if (this == obj) return true; if (obj == null) return false;
	   if (getClass() != obj.getClass()) return false; 
	   BankDto2 other = (BankDto2) obj; 
	   return Objects.equals(id, other.id); 
   }
   public String getId() { return id; } public void setId(String id) { this.id = id; }
   public String getPass() { return pass; } public void setPass(String pass) { this.pass = pass; }
   public double getBalance() { return balance; } public void setBalance(double balance) { this.balance = balance; }

   @Override public String toString() { return "BankDto2 [id=" + id + ", pass=" + pass + ", balance=" + balance + "]"; }
   public BankDto2() { }
   public BankDto2(String id, String pass, double balance) {
      super();
      this.id = id;
      this.pass = pass;
      this.balance = balance;
   } 
   
}

class Bank2{
   List<BankDto2>  users;   // 객체를 생성하는게 아니라 정보만 받을 목적
   public Bank2() { super(); }
   public Bank2(List<BankDto2> users) { super(); this.users = users; }
   
   // 메뉴 - 안에 내용작성
   public void menu() {
	   int menu=-1;
	   Scanner scanner = new Scanner(System.in);
//	   System.out.println( id + "\t" + pass + "\t" + balance);  // 계좌의 1명분  확인용
       while(menu!=9) {
    	   System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
    	             + "[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제  [9]종료\r\n"
    	             + "👉 번호를 선택하세요:");
	       menu = scanner.nextInt();
	       
	       if(menu==1) {  add();}
	       else {
	    	   //로그인확인
	    	   //각각의 메뉴에 맞는 기능호출
	       }
       }
   }   
   // 유저추가  (add)
   public void add() {
      //변수
      //입력 - 사용자에게 정보입력받기
      //처리 
      users.add( new BankDto2("aaa" , "pass" , 1 ) );
      //출력
   }
   // 유저로그인		- 유저정보		BankDto2 login(){}
   BankDto2 login(){ return null;}
   void     show( BankDto  user  ){
	     System.out.printf("ID : %s\nPASS: %s\nBALANCE: %.1f\n" ,user.getId(),user.getPass(), user.getBalance()); 
	   } 
   // 입금   (get)	- 			void	 deposit ( BankDto2 user ) {}
   void	 deposit ( BankDto2 user ) {}
   // 출금   (get)	- 			void	 withdraw( BankDto2 user ) {}
   void	 withdraw( BankDto2 user ) {}
   // 유저삭제(remove) - 			void	 delet	 ( BankDto2 user ) {}
   void	 delet	 ( BankDto2 user ) {}
   // 종료   			- 			void	 exit(  ) {}
   void	 exit(  ) {}
}
public class BankCollect_ver_t {
   public static void main(String[] args) {
      List<BankDto2>  users = new ArrayList<>();
      Bank2      controller = new Bank2(users);
      controller.menu();
      
      //테스트용
      //      controller.add();
      //      System.out.println(controller.users);
   }
}




