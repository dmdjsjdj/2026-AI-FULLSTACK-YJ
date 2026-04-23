package com.the703.basic010;

public class Milk{  // basic010에 설정해주세요!
	   private int  mno;   
	   private String mname;  
	   private  int mprice;
	   public Milk() { super(); }
	   public Milk(int mno, String mname, int mprice) { super(); this.mno = mno; this.mname = mname; this.mprice = mprice; }
	   @Override public String toString() { return "Milk [mno=" + mno + ", mname=" + mname + ", mprice=" + mprice + "]"; }
	   public void setMprice(int mprice) { this.mprice = mprice; } 
	}
