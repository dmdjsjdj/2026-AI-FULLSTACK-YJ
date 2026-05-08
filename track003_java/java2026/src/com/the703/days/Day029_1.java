package com.the703.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

//Q1. DTO 클래스 만들기
class Player1 {
	private String name;
	private int score;
	public Player1() { super(); }
	public Player1(String name, int score) { super(); this.name = name; this.score = score; }
	@Override public String toString() { return "Player [name=" + name + ", score=" + score + "]"; }
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public int getScore() { return score; } public void setScore(int score) { this.score = score; }
	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player1 other = (Player1) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
}

public class Day029_1 {
	public static void main(String[] args) {
//		List : 기차 (순서o, 중복o) add, get, size, remove, contains
//		Q2. List (ArrayList)  players 이름으로 ArrayList 만들기
//		Q3. List에서 출력을 보면 Bowser   900  라는 같은데이터를 넣었는데 2개가 나옴. 이유는?
//		List는 중복허용
		List<Player1> player = new ArrayList<>();
//		2-2. 데이터 추가:
		System.out.println("List----------");
		player.add(new Player1("Mario", 1200));
		player.add(new Player1("Luigi", 1500));
		player.add(new Player1("Peach", 1800));
		player.add(new Player1("Bowser", 900));
		player.add(new Player1("Bowser", 900));
//		2-3. for + size 이용해서 출력
		for(int i=0;i<player.size();i++) {
			System.out.println(i+1 +"  "+ player.get(i).getName()+"  "+player.get(i).getScore());
		}
System.out.println();
//		정렬 문제
//		6-1. List코드에서 익명 클래스로 점수 오름차순 정렬
		System.out.println("익명클래스 오름차순 정렬");
		player.sort(new Comparator<Player1>() {  //Comparator<? super Player1> c
			@Override public int compare(Player1 o1, Player1 o2) { 
				return Integer.compare(o1.getScore(), o2.getScore()); 
			}
		});
		int cnt = 0;
		for(Player1 p: player) {
			System.out.println(++cnt +"  "+ p.getName()+"  "+p.getScore());
		}
//		6-2. 람다식으로 점수 내림차순 정렬
		System.out.println("람다식 내림차순 정렬");
		player.sort(( o1,  o2)->Integer.compare(o2.getScore(), o1.getScore()));
		cnt = 0;
		for(Player1 p: player) {
			System.out.println(++cnt +"  "+ p.getName()+"  "+p.getScore());
		}
//		6-3. 메서드 참조로 점수 오름차순 정렬
		System.out.println("메서드 참조 오름차순 정렬");
		player.sort(Comparator.comparingInt(Player1::getScore));  //## 참조
		cnt = 0;
		for(Player1 p: player) {
			System.out.println(++cnt +"  "+ p.getName()+"  "+p.getScore());
		}
		
		
System.out.println();
//		Set : 주머니 (순서x, 중복x) add, put, size, remove, contains
//		Q4. Set (HashSet) 출력 setPlayers 이름으로 HashSet 만들기
		System.out.println("Set----------");
		Set<Player1> set = new HashSet<>();
		set.add(new Player1("Mario", 1200));
		set.add(new Player1("Luigi", 1500));
		set.add(new Player1("Peach", 1800));
		set.add(new Player1("Bowser", 900));
		set.add(new Player1("Bowser", 900));
//		4-2. 동일한 데이터 넣기 (중복 허용 안됨)
//		4-3. Iterator 이용해서 출력
		Iterator<Player1> it = set.iterator();  //1. 줄세우기
		cnt = 0;
		while(it.hasNext()) {  // 2. 처리대상 유무
			Player1 p = it.next(); //3. 한개씩 꺼내오기
			System.out.println(++cnt +"  "+ p.getName()+"  "+p.getScore());
		}

System.out.println();
//		Map : 기차 (key:value-쌍-엔트리) put, get(key), size, remove, contains
//		Q5. Map (HashMap) 출력  mapPlayers 이름으로 HashMap 만들기
		System.out.println("Map----------");
		Map<String, Player1> maps = new HashMap<>();
//		5-2.  데이터 넣기 (Key-Value 구조)
		maps.put("mario", new Player1("Mario", 1200));
		
		maps.put("luigi", new Player1("Luigi", 1500));
		maps.put("peach", new Player1("Peach", 1800));
		maps.put("bowser", new Player1("Bowser", 900));
//		5-3. for-each + entrySet 이용해서 출력
		for(Entry<String, Player1> e: maps.entrySet()) {
			System.out.println(e.getKey() +"  "+ e.getValue().getName()+"  "+e.getValue().getScore());
		}
	}
}
/*
Q1. Player DTO 클래스 만들기
속성:
private String name;
private int score;

Q2. List (ArrayList) 출력
2-1. players 이름으로 ArrayList 만들기
2-2. 데이터 추가:
new Player("Mario", 1200),
new Player("Luigi", 1500),
new Player("Peach", 1800),
new Player("Bowser", 900)
new Player("Bowser", 900)

2-3. for + size 이용해서 출력

출력 예시
1   Mario    1200
2   Luigi    1500
3   Peach    1800
4   Bowser   900
5   Bowser   900

Q3. List에서 출력을 보면 Bowser   900  라는 같은데이터를 넣었는데 2개가 나옴. 이유는?
4   Bowser   900
5   Bowser   900


Q4. Set (HashSet) 출력
4-1. setPlayers 이름으로 HashSet 만들기
4-2. 동일한 데이터 넣기 (중복 허용 안됨)
4-3. Iterator 이용해서 출력
출력 예시
1   Mario    1200
2   Luigi    1500
3   Peach    1800
4   Bowser   900

Q5. Map (HashMap) 출력
5-1. mapPlayers 이름으로 HashMap 만들기
5-2.  데이터 넣기 (Key-Value 구조)
mapPlayers.put("mario", new Player("Mario", 1200));
mapPlayers.put("luigi", new Player("Luigi", 1500));
mapPlayers.put("peach", new Player("Peach", 1800));
mapPlayers.put("bowser", new Player("Bowser", 900));
5-3. for-each + entrySet 이용해서 출력
출력 예시
mario   Mario    1200
luigi   Luigi    1500
peach   Peach    1800
bowser  Bowser   900

Q6. 정렬 문제
6-1. List코드에서 익명 클래스로 점수 오름차순 정렬
6-2. 람다식으로 점수 내림차순 정렬
6-3. 메서드 참조로 점수 오름차순 정렬

출력 예시 (오름차순)
코드
Bowser   900
Bowser   900
Mario    1200
Luigi    1500
Peach    1800
*/