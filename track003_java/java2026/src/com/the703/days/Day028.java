package com.the703.days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class MilkDto {
	private String mname; private int mprice;

	public MilkDto() { super(); }
	public MilkDto(String mname, int mprice) { super(); this.mname = mname; this.mprice = mprice; }
	@Override public String toString() { return "MilkDto [mname=" + mname + ", mprice=" + mprice + "]"; }
	public String getMname() { return mname; } public void setMname(String mname) { this.mname = mname; }
	public int getMprice() { return mprice; } public void setMprice(int mprice) { this.mprice = mprice; }
	@Override public int hashCode() { return Objects.hash(mname, mprice); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MilkDto other = (MilkDto) obj;
		return Objects.equals(mname, other.mname) && mprice == other.mprice;
	}
}

public class Day028 {
	public static void main(String[] args) {
		//milks 이름으로 ArrayList 만들기 / for + size 이용해서 데이터 출력 
		List<MilkDto> milks = new ArrayList<>();
		milks.add(new MilkDto("바나나우유", 1300));  
		milks.add(new MilkDto("메론맛우유", 1800)); 
		milks.add(new MilkDto("커피우유", 1500)); 
		milks.add(new MilkDto("커피우유", 1500)); 
		
		for(int i=0;i<milks.size();i++) {
			System.out.println(i+1 +"  "+ milks.get(i).getMname()+"   "+milks.get(i).getMprice());
		}
		System.out.println();
		//sets 이름으로 HashSet 만들기  / Iterator 이용해서 데이터 출력   
		Set<MilkDto> sets = new HashSet<>();
		sets.add(new MilkDto("바나나우유", 1300));  
		sets.add(new MilkDto("메론맛우유", 1800)); 
		sets.add(new MilkDto("커피우유", 1500)); 
		sets.add(new MilkDto("커피우유", 1500)); 
		
		Iterator<MilkDto> it = sets.iterator();
		int cnt=0;
		while(it.hasNext()) {
			MilkDto m = it.next();
			System.out.println(++cnt + "  "+ m.getMname()+ "  "+ m.getMprice());
		}
		System.out.println();
		//다음의 데이터 넣기 (Key-Value 구조)  / for-each + keySet 이용해서 데이터 출력  
		Map<String, MilkDto> maps = new HashMap<>();
		maps.put("banana", new MilkDto("바나나우유", 1300));  
	    maps.put("melon", new MilkDto("메론맛우유", 1800));  
	    maps.put("coffee", new MilkDto("커피우유", 1500));  
	    maps.put("coffee2", new MilkDto("커피우유", 1500)); 
	    
	    Set<String> keys = maps.keySet();
	    for(String k : keys) {
	    	MilkDto m = maps.get(k);
	    	System.out.println(k + "  "+ m.getMname()+ "  "+ m.getMprice());
	    }
	}
}


/*
Q1. 빈칸 채우기
1.  List는 순서가 [O] 구조로 데이터를 관리하며, 중복을 [O]
    - 주요 메서드: add, get, size, remove, contains
2. Set은 순서가[X] 구조로 데이터를 관리하며,  중복을 [X]
    - 주요 메서드: add, 향상된 for/Iterator, size, remove, contains
3. Map은 [key]와 [value]의 쌍으로 데이터를 관리한다. 
    - 주요 메서드: add, get(key), size, remove, contains
 
---

Q2. ArrayList, HashSet, HashMap을 작성하시오.  

1. Milk Dto 클래스 만들기  
   - 속성 : private String mname; private int mprice  

2. milks 이름으로 ArrayList 만들기  
3. 다음의 데이터 넣기  
   new Milk("바나나우유", 1300),  
   new Milk("메론맛우유", 1800),  
   new Milk("커피우유", 1500),  
   new Milk("커피우유", 1500)  
4. for + size 이용해서 데이터 출력  
```
1     바나나우유       1300
2     메론맛우유       1800
3     커피우유         1500
4     커피우유         1500
```
 
5. sets 이름으로 HashSet 만들기  
6. 다음의 데이터 넣기  
   new Milk("바나나우유", 1300),  
   new Milk("메론맛우유", 1800),  
   new Milk("커피우유", 1500),  
   new Milk("커피우유", 1500)  
7. Iterator 이용해서 데이터 출력   
```
1     바나나우유       1300
2     메론맛우유       1800
3     커피우유         1500
```
 
8. maps 이름으로 HashMap 만들기  
9. 다음의 데이터 넣기 (Key-Value 구조)  
   maps.put("banana", new Milk("바나나우유", 1300));  
   maps.put("melon", new Milk("메론맛우유", 1800));  
   maps.put("coffee", new Milk("커피우유", 1500));  
   maps.put("coffee2", new Milk("커피우유", 1500));  

10. for-each + keySet 이용해서 데이터 출력  
```
banana    바나나우유       1300
melon     메론맛우유       1800
coffee    커피우유         1500
coffee2   커피우유         1500
``` 

*/