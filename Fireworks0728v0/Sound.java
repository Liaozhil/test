package com.Liao.Fireworks0728v0;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class Sound implements Runnable {

	private Boolean isstop = false;
	private Player player;

	public void  setisstop(Boolean isstop){
		this.isstop=isstop;
	}
	
	public Player getplayer(){
		return player;
	}

	public void run() {
		while (!isstop) {
			try {
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream("file\\fireworks.mp3"));
				player = new Player(bis);
				player.play();
			} catch (Exception e) {
				System.out.println("进入异常中");
			//	isstop=true;
			//	return;
			}
		}
	}
}
