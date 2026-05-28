package com.the703.servlet;

import java.util.Objects;

public class Java001 {
	private int a;
	private int b;
	
	public Java001() { super(); }

	@Override public String toString() { return "Java001 [a=" + a + ", b=" + b + "]"; }

	public int getA() { return a; }  public void setA(int a) { this.a = a; }
	public int getB() { return b; }  public void setB(int b) { this.b = b; }

	public Java001(int a, int b) { super(); this.a = a; this.b = b; }

	@Override
	public int hashCode() {
		return Objects.hash(a, b);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Java001 other = (Java001) obj;
		return a == other.a && b == other.b;
	}
}
