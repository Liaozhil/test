package com.Liao.Fireworks0728v0;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainUI extends JFrame implements Config{

	private static final long serialVersionUID = 1L;
	private ImageIcon p0 = new ImageIcon(this.getClass().getResource("night_sky.png"));

	public static void main(String[] args) {
		new MainUI().init();
	}

	public void init() {
		//隐藏菜单栏
		this.setUndecorated(true);
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		//添加监听器
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//创建匿名对象，传递窗口（this）参数
				//启动线程
				new Thread(new ParticleControl(MainUI.this)).start();
				//移除监听器
				MainUI.this.removeMouseListener(this);
			}
		});
		this.setVisible(true);
	}
	//绘制初始背景
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(p0.getImage(), 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
	}
}
