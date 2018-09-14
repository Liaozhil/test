package com.Liao.Fireworks0728v0;

public interface Config {
	public static final int SCREEN_WIDTH = 1366;//屏幕宽度
	public static final int SCREEN_HEIGHT = 768;//屏幕高度
	public static final int SIZE = 16;//粒子大小
	public static final double DT  = 0.01;//时间变量
	public static final Vector_2 PSTART=new Vector_2(683,768);//粒子初始位置
	public static final Vector_2 VSTART=new Vector_2(0,-500);//粒子初始速度
	public static final Vector_2 ASTART=new Vector_2(0,200);//粒子初始加速度
}
