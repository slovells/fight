package com.slovell.fight.test;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.slovell.fight.model.Hero;
import com.slovell.fight.tools.GameValue;

public class PlayPNG extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3499834462590506137L;
	
	/**
	 * ½ÇÉ«Í¼Æ¬ËØ²Ä-ÓÒÕ¾*/
	public static Image[] stand_right= Hero.jump_right;
	
	int index=0;

	public PlayPNG() {
		// TODO Auto-generated constructor stub
		this.setTitle("Õ½¶·Ö÷´°Ìå");
		this.setBounds((int)(GameValue.WIDTH-GameValue.Width)/2,(int)(GameValue.HEIGHT-GameValue.Hight)/2,GameValue.Width,GameValue.Hight);
		this.setLayout(null);
		this.setResizable(false);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		this.setVisible(true);
		new refresh(this);
	}
	
	class refresh extends Thread{
		PlayPNG player;
		public refresh(PlayPNG play) {
			// TODO Auto-generated constructor stub
			player=play;
			this.start();
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				for(int i=0;i<stand_right.length;i++) {
					index=i;
					player.repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(stand_right[index],200,200,this);
	}
	
	public static void main(String[] args) {
		new PlayPNG();
	}
}