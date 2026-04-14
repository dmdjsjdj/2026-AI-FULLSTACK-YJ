package com.the703.basic008_ex;

import java.util.Arrays;

public class Array3Total_1 {

	public static void main(String[] args) {
		// 
		String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
	    int[] kor={100,100,100,70,35};   
	    int[] eng={100,100,100,80,35};
	    int[] mat={100,90,100,60,35};
	    int[] aver=new int[5];
	    String[] hap = new String[5];
	    String[] jang = new String[5];
	    int rank[] = {1,1,1,1,1};
	    int count=0;
	    
	    for(int i=0;i<name.length;i++) {
	    	aver[i]=(kor[i]+eng[i]+mat[i])/3;
	    	
	    	hap[i]=aver[i]>=60?"합격":"불합격";
	    	
	    	jang[i]=aver[i]>=95?"장학생":"----";
	    }
	    
	    // 평균 100 96 100 60 35
//	    for(int j=0;j<aver.length;j++) {
//	    	for(int k=0;k<aver.length;k++) {
//	    		if(aver[j]>aver[k]) {
//	    			int a=0;
//					for(int w =0; w<aver.length;w++) {
//						if(aver[w]==aver[k]) {
//							a=1;
//							break;
//						}
//					}
//					if(a==1) {
//		    			rank[k]++;
//		    		}
//				}
//	    		
//	    	} 
//	    }
	    // 2. 등수 계산 (동점자 동일 등수, 다음은 이어서 증가)
        // 평균과 인덱스를 함께 저장
	    
        Integer[] idx = new Integer[name.length];
        for(int i=0; i<idx.length; i++) idx[i] = i;

        // 내림차순 정렬
        Arrays.sort(idx, (a,b) -> aver[b] - aver[a]);

        int currentRank = 1;
        rank[idx[0]] = currentRank;
        for(int i=1; i<idx.length; i++) {
            if(aver[idx[i]] == aver[idx[i-1]]) {
                // 동점자 → 같은 등수
                rank[idx[i]] = currentRank;
            } else {
                // 새로운 점수 → 등수 증가
                currentRank++;
                rank[idx[i]] = currentRank;
            }
        }
        
	    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\r\n"
	    		+ "  이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹   \r\n"
	    		+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	    
	    for(int k=0;k<name.length;k++) {
	    	System.out.printf("%s\t%d\t%d\t%d\t%d\t%d등\t%s\t%s\t",name[k], kor[k], eng[k], mat[k], aver[k],rank[k], hap[k], jang[k]);
	    	for(int y=1;y<=aver[k]/10;y++) {
	    		System.out.print("★");
		    }System.out.println();
	    }
	    

	}

}
/*
패키지명 : com.the703.basic008_ex
클래스명 :  Array1Total
배열을 이용하여 다음의 프로그램을 작성하시오.   

    String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
    int[] kor={100,20,90,70,35};   
    int[] eng={100,50,95,80,100};
    int[] mat={100,30,90,60,100};
    int[] aver=new int[5];

     1. 평균구하시오.
     2. 합격,불합격   -  평균이 60점이상이면 합격, 아니면 불합격으로 처리하시오.
     3. 장학생   - 평균 95점이상이면 장학생으로 처리하시오. 
     4. 등수 추가
     5. 점수열 랭킹(100점-별10개)추가
      
3.출력예시:     
   :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
   이름      국어   영어   수학   평균   합격여부   장학생   
   :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
   아이언맨   100   100   100   100      합격   장학생   
   헐크      20   50   30   33   불합격   ----   
   캡틴      90   95   90   91   합격   ----   
   토르      70   80   60   70   합격   ----   
   호크아이   35   100   100   78      합격   ----   
   :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

   ※ 힌트1)    
    /////// 처리1 : 평균구하기  
    1-1. (국어+영어+수학)/3
   1-2.  아이언맨의 평균 =  아이언맨의 국의 + 아이언맨의 영어 + 아이언맨의 수학 
   1-3.  aver[0] = kor[0] + eng[0] + mat[0]
   
   1-2.  헐크의 평균 =  아이언맨의 국의 + 아이언맨의 영어 + 아이언맨의 수학 
   1-3.  aver[1] = kor[1] + eng[1] + mat[1]

   /////// 처리2 : 합격,불합격 
   2-1. 평균이 60점이상이면 합격    아니면 불합격
   2-2. 어디다가 합격, 불합격을 담아놓을 것인가? ※ 필요한것 : 합격,불합격을 담을 배열     
   2-3. 아이언맨의 평균이 60점 이상이라면 합격 / 아니면 불합격
   2-4. if(aver[0] >=60){   합격 } else{불합격} 

   /////// 처리3 : 장학생
   3-1. 평균 95점이상 장학생
   3-2. 어디다가 장학생을 담아놓을 것인가? ※ 필요한것 :  장학생 여부를 저장할 배열 
   3-3. 아이언맨의 평균이 95점이상이면 장학생 / 아니라면 ----
   3-4.  if(aver[0] >=95){ 장학생 } else{ ---- } 
*/