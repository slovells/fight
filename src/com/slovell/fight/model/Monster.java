package com.slovell.fight.model;

import java.awt.Image;
import java.util.Random;

import com.slovell.fight.main.FightGameLaunch;
import com.slovell.fight.panel.MainFrame;
import com.slovell.fight.tools.GameValue;

/**������*/
public class Monster implements Runnable{

	/**
	 * �����Ƿ���ı��*/
	public boolean islive=true;
	
	public boolean left=false,right=false;
	
	/**
	 * ����Ѫ��*/
	public int HP=50;
	
	/**
	 * ���﹥����*/
	public int atk=3;
	
	/**
	 * ��������
	 * 0    1*/
	public static int species;
	
	/**
	 * ����λ��*/
	public int mX=0,Y=Hero.Y+50;
	
	/**
	 * ���ﲽ��*/
	public static int step=5;
	
	/**
	 * ����ͼƬ����*/
	public int index=0;
	
	/**
	 * ����ͼƬ��Դ*/
	public Image[] imgs_left,imgs_right;
	
	private static Random rd=new Random();
	
	public Monster() {
		// TODO Auto-generated constructor stub
		species=rd.nextInt(GameValue.Monster_num);
		if(species==0) {
			imgs_left=GameValue.monster1_left;
			imgs_right=GameValue.monster1_right;
			step=5;
		}
		else if(species==1) {
			imgs_left=GameValue.monster2_left;
			imgs_right=GameValue.monster2_right;
			step=10;
			atk=5;
			HP=60;
		}
		mX=GameValue.Width-10;
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(islive && Hero.HP_NOW>0) {
			for(int i=0;i<imgs_right.length;i++) {
				index=i;
				if(mX>Hero.X) {
					left=true;
					right=false;
					mX-=step;
					
					/**��ʱ�ͽ�ɫ��ײ-�����ڽ�ɫ�ұ�*/
					if(mX-100<=Hero.X) {
						/**�жϽ�ɫ�Ƿ�����*/
						if(Hero.jump) {
							if(Hero.attack) {
								attacked(Hero.jump_attack_hp);
							}
							/**��������*/
							else {
								Hero.X-=100;
								if(Hero.X<0) {
									Hero.X=0;
								}
								Hero.attacked(atk);
							}
						}
						else {
							/**�չ�*/
							if(Hero.attack) {
								attacked(Hero.attack_hp);
							}
							/**���ܹ���*/
							else if(Hero.skill0_attack) {
								attacked(Hero.skill0_hp);
							}
							else {
								Hero.X-=100;
								if(Hero.X<0) {
									Hero.X=0;
								}
								Hero.attacked(atk);
							}
						}
					}
				}
				
				else {
					left=false;
					right=true;
					mX+=step;
					
					/**��ʱ�ͽ�ɫ��ײ-�����ڽ�ɫ���*/
					if(mX+110>=Hero.X) {
						/**�жϽ�ɫ�Ƿ�����*/
						if(Hero.jump) {
							if(Hero.attack) {
								attacked(Hero.jump_attack_hp);
							}
							/**��������*/
							else {
								Hero.X+=100;
								if(Hero.X+100>GameValue.Width) {
									Hero.X=GameValue.Width-100;
								}
								Hero.attacked(atk);
							}
						}
						else {
							/**�չ�*/
							if(Hero.attack) {
								attacked(Hero.attack_hp);
							}
							/**���ܹ���*/
							else if(Hero.skill0_attack) {
								attacked(Hero.skill0_hp);
							}
							else {
								Hero.X+=100;
								if(Hero.X+100>GameValue.Width) {
									Hero.X=GameValue.Width-100;
								}
								Hero.attacked(atk);
							}
						}
					}
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * ���ﱻ������<br>
	 * @param atk �����ܵ��Ĺ�����*/
	public void attacked(int atk) {
		if(this.left) {
			this.mX+=70;
			if(this.mX>GameValue.Width-70) {
				this.mX=GameValue.Width-70;
			}
		}
		else if(this.right) {
			this.mX-=70;
			if(this.mX<0) {
				this.mX=0;
			}
		}
		this.HP-=atk;
		if(this.HP<=0) {
			islive=false;
			MainFrame.monsters.remove(this);
		}
		FightGameLaunch.getMainFrame().repaint();
	}
}