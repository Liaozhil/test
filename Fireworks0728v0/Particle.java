package com.Liao.Fireworks0728v0;

import java.awt.Color;

public class Particle {
	//粒子位置、速度、加速度
	public Vector_2 position, velocity, acceleration;
	//粒子颜色
	public Color color;
	//粒子生命、年龄、宽度、长度
	public int life,age,width,height;

	public Particle() {
	}

	public int getX() {
		return (int) this.position.x;
	}

	public int getY() {
		return (int) this.position.y;
	}
}
