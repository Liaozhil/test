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
		//���ز˵���
		this.setUndecorated(true);
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		//��Ӽ�����
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//�����������󣬴��ݴ��ڣ�this������
				//�����߳�
				new Thread(new ParticleControl(MainUI.this)).start();
				//�Ƴ�������
				MainUI.this.removeMouseListener(this);
			}
		});
		this.setVisible(true);
	}
	//���Ƴ�ʼ����
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(p0.getImage(), 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
	}
}
