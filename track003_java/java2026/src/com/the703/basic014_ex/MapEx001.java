package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class MapEx001 {
	public static void main(String[] args) {
		//put, get, size, remove, contains
		Map<String, String> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String k;
		map.put("피구왕", "통키");
		map.put("제빵왕", "김탁구");
		map.put("요리왕", "비룡");
		
		System.out.println("==============================\r\n"
				+ "KING   NAME\r\n");
		for(Entry<String, String> m : map.entrySet()) {
			String    key = m.getKey();
			String value = m.getValue();
			System.out.println(key+"   "+ value);
			System.out.println("---------------");
		}
		System.out.print("KING의 정보를 제공중입니다\r\n"
				+ "이름을 입력하세요> ");
		k=sc.next();
		
		System.out.println( map.containsKey(k) ? "ㅁ"+k+":"+ map.get(k): "찾으시는 왕이 없습니다.");

		
	}
}
/*
연습문제1)  Collection  Framework
패키지명 : com.the703.basic014_ex
클래스명 : MapEx001
1. MAP 만들기
KEY   VALUE
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡

Map<String, String> map = new HashMap<>();

2 다음과 같이 문제풀기
2-1. 다음과 같이 출력
2-2. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
==============================
KING   NAME
==============================
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡
---------------------
KING의 정보를 제공중입니다
이름을 입력하세요> 제빵왕

ㅁ제빵왕 : 김탁구
*/