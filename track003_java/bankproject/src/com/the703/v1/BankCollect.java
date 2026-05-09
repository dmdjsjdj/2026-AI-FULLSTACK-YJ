package com.the703.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//1. Dto 데이터전송목적
class BankDto{
	private String id;
	private String pass;
	private double balance;
	
	public BankDto() { super(); }
	public BankDto(String id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	}
	@Override public String toString() { return "BankDto [id=" + id + ", pass=" + pass + ", balance=" + balance + "]"; }
	public String getId() { return id; } 
	public void setId(String id) { this.id = id; }
	public String getPass() { return pass; } 
	public void setPass(String pass) { this.pass = pass; }
	public double getBalance() { return balance; } 
	public void setBalance(double balance) { this.balance = balance; }
	@Override public int hashCode() { return Objects.hash(balance, id, pass); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankDto other = (BankDto) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(id, other.id) && Objects.equals(pass, other.pass);
	}
}

class Bank1{
	List<BankDto>  users;   // 객체를 생성하는게 아니라 정보만 받을 목적
	
	public Bank1() { super(); }
	public Bank1(List<BankDto> users) { super(); this.users = users; }
	
	// 메뉴 - 안에 내용작성
	public void menu() {}   
	// 유저추가  (add)
	public void add() {
		//변수
		//입력 - 사용자에게 정보입력받기
		//처리 
		users.add( new BankDto("aaa" , "pass" , 1 ) );
		//출력
	}
	// 입금   (get)
	// 출금   (get)
	// 유저삭제(remove)
	// 종료   
}
public class BankCollect {
	public static void main(String[] args) {
		List<BankDto>  users = new ArrayList<>();
		Bank1      controller = new Bank1(users);
		controller.menu();
		
		//테스트용
		//		controller.add();
		//		System.out.println(controller.users);
	}
}




