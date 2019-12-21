package com.slovell.fight.tools;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.slovell.fight.main.FightGameLaunch;
import com.slovell.fight.model.Hero;

public class KeyWork implements KeyListener {
	
	public static boolean pressA=false,pressD=false;
	boolean pressDown=false;
	
	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		int key=ke.getKeyCode();
		switch(key) {
		
			/**
			 * 按下esc键退出*/
			case KeyEvent.VK_ESCAPE:
				FightGameLaunch.getMainFrame().isclose();
				break;
				
			/**
			 * 按下空格跳*/	
			case KeyEvent.VK_SPACE:
				Hero.jump=true;
				break;
				
			/**
			 * 左*/
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:
				pressA=true;
				Hero.left=true;
				Hero.walk=true;
				Hero.right=false;
				break;
				
			/**
			 * 右*/	
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
				pressD=true;
				Hero.right=true;
				Hero.walk=true;
				Hero.left=false;
				break;
				
			/**
			 * 按住S或者下*/
			case KeyEvent.VK_DOWN:	
			case KeyEvent.VK_S:
				pressDown=true;
				break;
				
			/**
			 * 可以释放一技能*/
			case KeyEvent.VK_K:
				if(Hero.MP_NOW>=Hero.skill0_mp && pressDown) {
					Hero.skill0_attack=true;
				}
				break;
				
			/**
			 * 攻击*/
			case KeyEvent.VK_J:
				Hero.attack=true;
				break;
				
			/**
			 * 测试*/
			case KeyEvent.VK_0:
				Hero.MP_NOW+=100;
				break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		int key=ke.getKeyCode();
		switch(key) {
				
			/**
			 * 释放空格*/	
			case KeyEvent.VK_SPACE:
				break;
				
			/**
			 * 左*/
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:
				pressA=false;
				Hero.right=false;
				Hero.walk=false;
				Hero.left=true;
				break;
				
			/**
			 * 右*/	
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
				pressD=false;
				Hero.left=false;
				Hero.walk=false;
				Hero.right=true;
				break;
				
			/**
			 * 松开S或者下*/
			case KeyEvent.VK_DOWN:	
			case KeyEvent.VK_S:
				pressDown=false;
				break;
		}
		FightGameLaunch.getMainFrame().repaint();
	}

	@Override
	public void keyTyped(KeyEvent ke) {}

}
