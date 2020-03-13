package com.example;

import java.util.List;

// record Point(int x,int y) {}

class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
public class StudyVar {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		var numbers = List.of(Integer.valueOf(4),8L, 15f, 16, 23, 42.);
		// 15f -> Float
		// 8L -> Long
		// 4 -> Integer
		// "16" -> String
		// 42. -> Double
		// JLS: Java Language Spec.
		Object o = 42L;
		if (o instanceof Number) { // guard
			Number num = (Number) o;
			
		}
		
//		if (o instanceof Number num) { // guard
//		   System.out.println(num);
//		}
	}

}
