package com.slovell.fight.tools;

/**
 * ÓÎÏ·¶¨Ê±Æ÷*/
public class GameTimer implements Runnable {

	int times;
	
	public GameTimer(int ms) {
		// TODO Auto-generated constructor stub
		times=ms;
		Thread t=new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
