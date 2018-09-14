package com.Liao.Fireworks0728v0;

public class Vector_2 {
	
	public double x,y;
	
	public Vector_2(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	//向量加法
	public Vector_2  add(Vector_2 v){
		return new Vector_2(this.x+v.x,this.y+v.y);
	}
	//向量乘法
	public Vector_2  multiply(double d){
		return new Vector_2(this.x*d,this.y*d);
	}
}
