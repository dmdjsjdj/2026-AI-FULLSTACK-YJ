package com.the703.basic014_ex;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class BookDTO {
    private String title;
    private String author;
    // 생성자, getter/setter, toString()
	public BookDTO() { super(); }
	public BookDTO(String title, String author) { 
		super(); this.title = title; this.author = author; }
	@Override public String toString() { return title + " | " + author; }
	public String getTitle() { return title; } 
	public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; } 
}

public class MapEx003 {
	public static void main(String[] args) {
		Map<String, Map<String, BookDTO>> library = new HashMap<>();
		String[][] data = {
		        {"서울점", "978-11111", "자바의 정석", "남궁성"},
		        {"서울점", "978-22222", "파이썬 기초", "홍길동"},
		        {"부산점", "978-33333", "자료구조와 알고리즘", "이순신"},
		        {"부산점", "978-44444", "파이썬 심화", "홍길동"}
		};
		System.out.println(data.length);
		System.out.println("=== 도서관 전체 목록 ===");
		for(int i=0;i<data.length;i++) {
					// data[0][0] data[0][1] data[0][2] data[0][3]
//			Map<String,BookDTO> lib = new HashMap<>();
//			lib.put(data[i][i+1], new BookDTO(data[i][i+2], data[i][i+3]));
//			System.out.println(lib);
//			library.put(data[i][i], new BookDTO(lib));
		}
	}
}
/*
## 📘 연습문제3) Collection Framework + 중첩 HashMap
패키지명 : com.company.basic014_ex
클래스명 : MapEx003

### 요구사항
1. 중첩 Map 구조 만들기  
   - Map<String, Map<String, BookDTO>> library = new HashMap<>();  
   - 첫 번째 Key : 도서관 지점 이름 (예: "서울점", "부산점")  
   - 두 번째 Key : ISBN  
   - Value : BookDTO 객체  
   - 다음의 데이터 이용할것
    String[][] data = {
        {"서울점", "978-11111", "자바의 정석", "남궁성"},
        {"서울점", "978-22222", "파이썬 기초", "홍길동"},
        {"부산점", "978-33333", "자료구조와 알고리즘", "이순신"},
        {"부산점", "978-44444", "파이썬 심화", "홍길동"}
    };


2. DTO 클래스  
   java
   class BookDTO {
       private String title;
       private String author;
       // 생성자, getter/setter, toString()
   }
   

3. 출력하기  
   - 각 지점별 도서 목록 출력  

4. 사용자 입력받기  
   - 지점 이름과 ISBN을 입력받아 해당 도서 정보 출력  

### 📌 실행 예시 
=== 도서관 전체 목록 ===
📚 서울점
978-11111 | 자바의 정석 | 남궁성
978-22222 | 파이썬 기초 | 홍길동
---------------------
📚 부산점
978-33333 | 자료구조와 알고리즘 | 이순신
978-44444 | 파이썬 심화 | 홍길동
---------------------
지점 이름 입력> 서울점
ISBN 입력> 978-22222

📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동
*/