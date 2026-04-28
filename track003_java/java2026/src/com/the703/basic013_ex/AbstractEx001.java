package com.the703.basic013_ex;

//1) 상속도
//Object
//  ↑
// Robot {   abstract charge() , move() , speak() }
//↑          ↑               ↑ 
//CleaningRobot  SecurityRobot   CookingRobot   
//{@charge() ,    {@charge() ,    {@charge() ,
//@ move() ,     @move() ,           @move() , 
//@ speak() }}         @speak() }}          @speak() }}  

abstract class Robot {
	String name;
	int level;
	abstract void charge();
	abstract void move();
	abstract void speak();
} //end class
class CleaningRobot extends Robot {
	@Override void charge() { System.out.print(super.name + "청소로봇 충전 중... 배터리 "); }
	@Override void move()   { System.out.println(super.name + "청소로봇: 청소 중"); }
	@Override void speak()  { System.out.println(super.name + "청소로봇: 먼지를 제거합니다!"); } 
}
class SecurityRobot extends Robot {
	@Override void charge() { System.out.print(super.name + "경비로봇 태양광 충전 중... 배터리 "); }
	@Override void move()   { System.out.println(super.name + "경비로봇: 경비 중"); }
	@Override void speak()  { System.out.println(super.name + "경비로봇: 이상 없음. 안전 확보!"); } 
}
class CookingRobot extends Robot {
	@Override void charge() { System.out.print(super.name + "요리로봇 인덕션 충전 중... 배터리 "); }
	@Override void move()   { System.out.println(super.name + "요리로봇: 요리 중"); }
	@Override void speak()  { System.out.println(super.name + "요리로봇: 오늘의 메뉴는 파스타입니다!"); } 
}


public class AbstractEx001 {
	   public static void main(String[] args) {
	      //Robot robot  = new Robot();  // Q1.why? 오류이유?  abstract 클래스
	      System.out.println("\n--- 로봇 배열 시뮬레이션 ---");
	      //  부모			자식
	      Robot [] bots = { new CleaningRobot(), new SecurityRobot() , new CookingRobot() };
	      int[] levels = { 50, 70, 95 };
	      int cnt=0;
	     
// bot[0] = 1번지  {@charge() ,@move() ,  @speak() }-{ model, battery/ ---, ---, ---}
// bot[1] = 2번지  {@charge() ,@move() ,  @speak() }-{ model, battery/ ---, ---, ---}
// bot[2] = 3번지  {@charge() ,@move() ,  @speak() }-{ model, battery/ ---, ---, ---}	     
//	      bots[0].name="Robo"+(0+1);
//	      bots[0].level=levels[0];
//	      bots[0].charge();
	      
	      for( Robot b : bots  ) { 
	    	  b.name = "Robo" + (cnt+1) +" "; b.charge(); System.out.println(levels[cnt]+"%");//b.level = levels[cnt]+"%";
	    	  b.move();
	    	  b.name = "Robo" + (cnt+1) +" "; b.speak(); cnt++;
	      }
	      for(int i=0; i<bots.length; i++){
	            bots[i].name = "Robo" + (i+1);
	            bots[i].level = levels[i];
//	            System.out.print( bots[i].name );
	            bots[i].charge();  
	            System.out.println( bots[i].level + "%");
	            bots[i].speak();
	         }  
	    
	   }
}
/*		ver-2
package com.the703.basic013_ex;

abstract class Robot{
   String model;  int battery;
   abstract void charge();  // 충전방식
   abstract void move();    // 이동방식
   abstract void speak();   // 말하기방식
} // end class
class CleaningRobot  extends Robot{
   @Override void charge() { System.out.println(super.model +  "청소로봇 충전 중... 배터리" + super.battery + "%"); }
   @Override void move()   { System.out.println(super.model +"청소로봇 : 청소 중"); }
   @Override void speak()  { System.out.println(super.model +"청소로봇: 먼지를 제거합니다!");  }
} 
class SecurityRobot  extends Robot{
   @Override void charge() { System.out.println(super.model +"경비로봇 태양광 충전 중... 배터리"+ super.battery + "%"); }
   @Override void move()   { System.out.println(super.model +"경비로봇 : 경비 중"); }
   @Override void speak()  { System.out.println(super.model +"경비로봇: 이상 없음. 안전 확보!");  }
} 
class CookingRobot   extends Robot{
   @Override void charge() { System.out.println(super.model +"요리로봇 인덕션 충전 중... 배터리"+ super.battery + "%"); }
   @Override void move()   { System.out.println(super.model +"요리로봇 : 요리 중"); }
   @Override void speak()  { System.out.println(super.model +"요리로봇: 오늘의 메뉴는 파스타입니다!");  }
}

public class AbstractEx001 {
   public static void main(String[] args) {
         //Robot robot  = new Robot();  // Q1.why? 오류이유?  abstract 클래스  
         System.out.println("\n--- 로봇 배열 시뮬레이션 ---");
         //  부모            자식
         Robot [] bots = { new CleaningRobot(), new SecurityRobot() , new CookingRobot() };
         int[] levels = { 50, 70, 95 }; 

      //bots[0] = 1번지 CleaningRobot{@charge(),@move() , @ speak() }-Robot{ model , battery / ---, ---, ---}   
      //bots[1] = 2번지 SecurityRobot{@charge(),@move() , @ speak() }-Robot{ model , battery / ---, ---, ---}   
      //bots[2] = 3번지  CookingRobot{@charge(),@move() , @ speak() }-Robot{ model , battery / ---, ---, ---}      
         
         for(int i=0; i<bots.length; i++){
            bots[i].model = "Robo" + (i+1);
            bots[i].battery = levels[i]; 
            bots[i].charge();   
            bots[i].speak();
         }   
         
//         Robo1 청소로봇 충전 중... 배터리 50%
//         Robo1 청소로봇: 먼지를 제거합니다!         
   }
}

 */
/*
연습문제1)
패키지명 : com.the703.basic013_ex 
클래스명 : AbstractEx001.java 
주어진조건 : 
1) 상속도
           Object
             ↑
            Robot {   abstract charge() , move() , speak() }
   ↑          ↑               ↑ 
CleaningRobot  SecurityRobot   CookingRobot   
{@charge() ,    {@charge() ,    {@charge() ,
 @ move() ,     @move() ,           @move() , 
 @ speak() }}         @speak() }}          @speak() }}

2)main
public class AbstractEx001 {
   public static void main(String[] args) {
      //Robot robot  = new Robot();  // Q1.why? 오류이유?
      System.out.println("\n--- 로봇 배열 시뮬레이션 ---");
      Robot [] bots = { new CleaningRobot(), new SecurityRobot() , new CookingRobot() };
      int[] levels = { 50, 70, 95 };
    
   }
}
 
출력화면 :  
--- 로봇 배열 시뮬레이션 ---
Robo1 청소로봇 충전 중... 배터리 50%
Robo1 청소로봇: 먼지를 제거합니다!
Robo2 경비로봇 태양광 충전 중... 배터리 70%
Robo2 경비로봇: 이상 없음. 안전 확보!
Robo3 요리로봇 인덕션 충전 중... 배터리 95%
Robo3 요리로봇: 오늘의 메뉴는 파스타입니다!
*/