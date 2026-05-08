package com.the703.basic015;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream003 {
	public static void main(String[] args) {
		Integer[]  ages = {17 , 21, 26 , 45, 18};
		
		Stream<Integer> stream = Arrays.stream(ages);
		
		//Ex1. 짝수만 출력 (짝수만: filter / 각각출력: forEach)
		//boolean java.util.function.Predicate.test( T t )
		System.out.println("Ex1. 짝수만 출력");
		stream.filter((t)->t%2==0)
			  .sorted()
			  .forEach(System.out::println);
System.out.println();		

		//Ex2. 평균값 처리  (숫자들을 더해서 연산)
		//(t)->{ return }
		//int java.util.function.ToIntFunction.applyAsInt( T value )
		stream = Arrays.stream(ages);  //일회용이라 다시 선언
		System.out.println("Ex2. 평균값 처리");
		double aver = stream.mapToInt(age->age)  //IntStream으로 변환
							.average()		     //집계) average(평균계산), max(최대), min(최소), sum(합), count(개수)
							.orElse(0.0);		 //값없으면 0.0
		System.out.println(aver);
System.out.println();

		//Ex3. 제일 나이가 많은 사람
		stream = Arrays.stream(ages);
		System.out.println("Ex3. 제일 나이가 많은 사람");
		int m = stream.mapToInt(age->age)  //IntStream으로 변환
							.max()			  //집계) average(평균계산), max(최대), min(최소), sum(합), count(개수)
							.orElse(-1);      // 값 없으면 -1
		System.out.println(m);
System.out.println();

		//Ex4. 나이 정렬해서 리스트로
		System.out.println("Ex4. 나이 정렬해서 리스트로");
		List<Integer> list = Arrays.stream(ages)
								.sorted()
								.collect(Collectors.toList());
		System.out.println("정렬된 리스트: "+ list);
System.out.println();	

		//Ex5. 20살 이상만 필터링해서 리스트로 수집
		//boolean java.util.function.Predicate.test( T t )
		// (t)->{return}
		System.out.println("Ex5. 20살 이상만 필터링해서 리스트로 수집");
		List<Integer> ad = Arrays.stream(ages)
								 .filter(t->t>=20)
								 .sorted()
//								 .sorted(Comparator.reverseOrder())//내림차순
								 .collect(Collectors.toList());
		System.out.println("20살 이상만 필터링, 정렬된 리스트: "+ ad);
	}
}








