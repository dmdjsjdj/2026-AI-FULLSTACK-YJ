package com.the703.v1;

////콜렉션 프레임워크로 작성한 ArrayList 버전
////map - key value
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//import java.util.Scanner;
//
//class User {
//	private String id;
//	private String pw;
//	private double bal;
//	public User() { super(); }
//	public User(String id, String pw, double bal) { 
//			super(); this.id = id; this.pw = pw; this.bal = bal; }
//	@Override public String toString() { 
//					return "Bservice [id=" + id + ", pw=" + pw + ", bal=" + bal + "]"; }
//	public String getId() { return id; } public void setId(String id) { this.id = id; }
//	public String getPw() { return pw; } public void setPw(String pw) { this.pw = pw; }
//	public double getBal() { return bal; } public void setBal(double bal) { this.bal = bal; }
//	@Override public int hashCode() { return Objects.hash(bal, id, pw); }
//	@Override public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		return Double.doubleToLongBits(bal) == Double.doubleToLongBits(other.bal) 
//				&& Objects.equals(id, other.id) && Objects.equals(pw, other.pw);
//	}
//}
//class Bank{
//	List<BankDto>  users;   // 객체를 생성하는게 아니라 정보만 받을 목적
//	
//	public Bank() { super(); }
//	public Bank(List<BankDto> users) { super(); this.users = users; }
//	
//	// 메뉴 - 안에 내용작성
//	public void menu() {}   
//	// 유저추가  (add)
//	public void add() {
//		//변수
//		//입력 - 사용자에게 정보입력받기
//		//처리 
//		users.add( new BankDto("aaa" , "pass" , 1 ) );
//		//출력
//	}
//	// 입금   (get)
//	// 출금   (get)
//	// 유저삭제(remove)
//	// 종료   
//}
//public class Bank_v4 {
//	public static void main(String[] args) {
//		
//	    List<User> user = new ArrayList<>();
//	     
//	    int menu=-1;  
//	    Scanner sc = new Scanner(System.in);
//	    int i=0;
//		
//		int putm=-1; 
//		char deletid= '\u0000';
//		String id2 = " ";
//		String pw2 = " ";
//		
//		System.out.print("\n 🌟💰 welcome to bank 💰🌟\r\n");
//		
//		while( menu!=9 ) {
//			System.out.println(user);
//			System.out.print("\n -- bank menu --\r\n"
//					 + "\r\n"
//					 + "1.➕계좌 추가\r\n" 
//					 + "2.🔍계좌 조회\r\n" 
//					 + "3.💵입금\r\n" 
//					 + "4.💸 출금\r\n" 
//					 + "5.🗑️삭제\r\n" 
//					 + "6.🔧비번 수정\r\n" 
//					 + "9.종료\r\n"
//					 + "\r\n"+"👉 번호를 선택하세요: ");
//			
//			menu = sc.nextInt();
//			i=0;
//
//			if(menu==9) {  //9.종료 >> 종료합니다.
//					System.out.println("종료합니다.");
//				} 
//			else if (menu==1) { //1.추가 - 아이디 id, 비번 pw, 잔액 balance
//				
//				for( i=0;i<user.size();i++) {
//					if(user.get(i).getId()!=null) {
//						continue;
//					}
//					else if(id[i]==null) {
//						System.out.print("아이디: ");
//						id[i] = sc.next();
//						System.out.print("비밀번호: ");
//						pw[i] = sc.next();
//						do {
//							System.out.print("잔액: ");
//							balance[i] = sc.nextInt();
//						}while(balance[i]<0);
//					}break;
//				}
//			} 
//			
//			else if (menu>=2 && menu<=6) {  
//				System.out.print("아이디: ");
//				id2 = sc.next();
//				System.out.print("비밀번호: ");
//				pw2 = sc.next();
//				
//				for( i=0;i<id.length;i++) {
//					if( !id[i].equals(id2) && !pw[i].equals(pw2)) {
//						continue;
//					}
//					//  if( id.equals(id2) || pw.equals(pw2)) { continue; }
//					else if( id[i].equals(id2) && pw[i].equals(pw2)) {
//						
//						
//						switch(menu) {
//						case 2: System.out.println("잔액: "+ balance[i] + "원"); break;
//							    
//						
//						case 3: System.out.print("입금금액: "); 
//								inputm = sc.nextInt();
//								
//								if(inputm>=0) {
//									balance[i] = balance[i] + (double)inputm;
//									System.out.println("잔액: "+ balance[i] + "원");
//								}
//								else { 
//										System.out.println("음수는 입력할 수 없습니다"); 
//								} break;
//								
//						case 4: System.out.print("출금금액: "); 
//								outputm = sc.nextInt();
//								
//								if(outputm>=0 && balance[i]-(double)outputm>=0) {
//									balance[i] = balance[i] - (double)outputm;
//									System.out.println("잔액: "+ balance[i] + "원");
//								}
//								else { 
//										System.out.println("잔액이 부족합니다.  현재 잔액"+balance[i]); 
//								} break;
//								
//						case 5: System.out.print("계좌를 삭제하시겠습니까?: ( y / n ) "); 
//								deletid = sc.next().charAt(0);
//								
//								if(deletid == 'y') {
//									System.out.println("계좌가 삭제되었습니다.");
//									id[i] = null;
//									pw[i] = null;
//								} else if(deletid == 'n') {
//									System.out.println("계좌 삭제를 취소하셨습니다.");
//								   } break;
//						
//						case 6: System.out.print("변경할 비밀번호: ");
//								pw2 = sc.next();
//								
//								pw[i] = pw2;
//								
//								break;
//								
//						
//						
//						default: System.out.println("잘못된 숫자입력입니다."); break;
//						};	 
//					}break;
//					
//				}
//				
//				
//			}
//			else {
//					System.out.println("\n 잘못된 입력입니다.");
//				}
//		}
//	}
//}

