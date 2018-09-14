package com.Liao.Fireworks0728v0;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ParticleControl implements Runnable, Config {
	private JFrame jf;
	private ImageIcon p0 = new ImageIcon(this.getClass().getResource("night_sky.png"));// ����ͼƬ
	private BufferedImage image = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
	private Graphics bg = image.getGraphics();
	private ArrayList<Particle> plist = new ArrayList<Particle>();
	private Sound sound = new Sound();
	private Thread thread;
	private int j;// �̻�����

	public ParticleControl(JFrame jf) {
		super();
		this.jf = jf;
		// �����Ч
		thread = new Thread(sound);
		thread.start();
	}

	public void run() {
		raise();
	}

	// �̻�����
	public void raise() {
		// 20��
		for (j = 0; j < 20; j++) {
			// �������ӣ��̻���
			Particle rp = new Particle();
			rp.position = PSTART;
			rp.velocity = VSTART;
			rp.acceleration = ASTART;
			rp.color = new Color(255, 150, 150);
			rp.width = SIZE / 2;
			rp.height = SIZE;
			//�趨����������������
			rp.life = 80 + new Random().nextInt(50);
			for (rp.age = 1; rp.age < rp.life; rp.age++) {
				// ����λ��
				rp.position = rp.position.add(rp.velocity.multiply(DT));
				rp.velocity = rp.velocity.add(rp.acceleration.multiply(DT));
				// ��������
				bg.setColor(rp.color);
				bg.drawImage(p0.getImage(), 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
				bg.fillOval(rp.getX(), rp.getY(), rp.width, rp.height);
				jf.getGraphics().drawImage(image, 0, 0, null);
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// ���ñ�ըЧ��
			bomp(rp);
		}
	}

	// ���̻�
	public void bomp(Particle rp) {
		//�趨��ը������������
		rp.life = 40 + new Random().nextInt(30);
		for (rp.age = 1; rp.age < rp.life; rp.age++) {
			for (int i = 0; i < 30; i++) {
				Particle p = new Particle();
				p.position = new Vector_2(rp.getX(), rp.getY());
				p.velocity = new Vector_2(2, -10);
				p.acceleration = particleDirection();
				p.color = new Color(200 + new Random().nextInt(55), (new Random().nextInt(50) + (i + j) * 100) % 255,
						new Random().nextInt(255));
				p.width = SIZE / 3;
				p.height = SIZE / 3;
				plist.add(p);
			}
			bg.drawImage(p0.getImage(), 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
			for (Particle p : plist) {
				// ����ÿ�����ӵ���һλ��
				p.position = p.position.add(p.velocity.multiply(DT));
				p.velocity = p.velocity.add(p.acceleration.multiply(DT));
				// ����������
				bg.setColor(p.color);
				bg.fillOval(p.getX(), p.getY(), p.width, p.height);
			}
			jf.getGraphics().drawImage(image, 0, 0, null);
			try {
				Thread.sleep(20);
			} catch (Exception ef) {
			}
		}
		plist.clear();
		jf.getGraphics().drawImage(p0.getImage(), 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
		// �ر�����
		if (j == 19) {
			sound.setisstop(true);
			sound.getplayer().close();
			//�رմ���
			jf.dispose();
		}
	}

	// ����һ������������Ӽ��ٶȣ�
	public static Vector_2 particleDirection() {
		double theta = Math.random() * 2 * Math.PI;
		return new Vector_2(100 + (Math.cos(theta) * 700), 100 + (Math.sin(theta) * 700));
	}
}
