package com.slovell.fight.model;

import java.awt.Image;
import java.util.Random;

import com.slovell.fight.main.FightGameLaunch;
import com.slovell.fight.panel.MainFrame;
import com.slovell.fight.tools.GameValue;

/**怪物类*/
public class Monster implements Runnable{

	/**
	 * 怪物是否存活的标记*/
	public boolean islive=true;
	
	public boolean left=false,right=false;
	
	/**
	 * 怪物血量*/
	public int HP=50;
	
	/**
	 * 怪物攻击力*/
	public int atk=3;
	
	/**
	 * 怪物种类
	 * 0    1*/
	public static int species;
	
	/**
	 * 怪物位置*/
	public int mX=0,Y=Hero.Y+50;
	
	/**
	 * 怪物步长*/
	public static int step=5;
	
	/**
	 * 怪物图片索引*/
	public int index=0;
	
	/**
	 * 怪物图片资源*/
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
					
					/**此时和角色碰撞-妖怪在角色右边*/
					if(mX-100<=Hero.X) {
						/**判断角色是否跳起*/
						if(Hero.jump) {
							if(Hero.attack) {
								attacked(Hero.jump_attack_hp);
							}
							/**单纯跳起*/
							else {
								Hero.X-=100;
								if(Hero.X<0) {
									Hero.X=0;
								}
								Hero.attacked(atk);
							}
						}
						else {
							/**普攻*/
							if(Hero.attack) {
								attacked(Hero.attack_hp);
							}
							/**技能攻击*/
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
					
					/**此时和角色碰撞-妖怪在角色左边*/
					if(mX+110>=Hero.X) {
						/**判断角色是否跳起*/
						if(Hero.jump) {
							if(Hero.attack) {
								attacked(Hero.jump_attack_hp);
							}
							/**单纯跳起*/
							else {
								Hero.X+=100;
								if(Hero.X+100>GameValue.Width) {
									Hero.X=GameValue.Width-100;
								}
								Hero.attacked(atk);
							}
						}
						else {
							/**普攻*/
							if(Hero.attack) {
								attacked(Hero.attack_hp);
							}
							/**技能攻击*/
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
	 * 怪物被攻击了<br>
	 * @param atk 妖怪受到的攻击力*/
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