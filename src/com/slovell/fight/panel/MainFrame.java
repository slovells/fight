package com.slovell.fight.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.slovell.fight.model.Hero;
import com.slovell.fight.model.Monster;
import com.slovell.fight.tools.GameValue;
import com.slovell.fight.tools.KeyWork;

/**
 * 游戏主界面*/
public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7492509868810783126L;
	private static KeyWork key;
	
	//双缓冲方法解决闪烁问题
	Image ImageBuffer=null;	
	Graphics img;

	/**实现动画<br>
	 * 图片帧索引<br>
	 * sri:stand_right_index:人物静止站立（右）<br>
	 * sli:stand_left_index:人物静止站立（左）<br>
	 * jri:jump_right_index:人物跳动作（右）<br>
	 * jli:jump_left_index:人物跳动作（左）<br>
	 * wli:walk_left_index:人物行走（左）<br>
	 * wri:walk_right_index:人物行走（右）<br>
	 * ari:attack_right_index:人物攻击（右）<br>
	 * ali:attach_left_index:人物攻击（左）<br>
	 * s0i:skill0_index:一技能攻击*/
	public static int sri=0,sli=0,jri=0,jli=0,wli=0,wri=0,
			ari=0,ali=0,s0i=0;
	
	/**场景*/
	int bgindex=0;
	
	public static List<Monster> monsters=new ArrayList<Monster>();
	
	public MainFrame() {
		this.setTitle("战斗主窗体");
		this.setBounds((int)(GameValue.WIDTH-GameValue.Width)/2,(int)(GameValue.HEIGHT-GameValue.Hight)/2,GameValue.Width,GameValue.Hight);
		this.setLayout(null);
		this.setResizable(false);
		key=new KeyWork();
		this.addKeyListener(key);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				isclose();
			}
			
		});
		initMonster();
		new ActionThread();
	}
	
	private void initMonster() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						Monster m=new Monster();
						monsters.add(m);
						/**
						 * 生成妖怪的间隔*/
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void isclose() {
		System.exit(0);
		int choose=JOptionPane.showConfirmDialog(this,"是否退出？",
				"退出",JOptionPane.YES_NO_OPTION);
		if(choose==0){
			System.exit(0);
		}
		else
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public void display(boolean show) {
		this.setVisible(show);
	}

	@Override
	public void paint(Graphics g) {
		if(ImageBuffer==null){
			ImageBuffer=createImage(this.getWidth(),this.getHeight());
		}
		img=ImageBuffer.getGraphics();
		super.paint(img);
		
		img.drawImage(GameValue.bgimgs[bgindex],0,0,GameValue.Width,GameValue.Hight,this);
		
		/**
		 * 构建主角信息*/
		img.setColor(Color.WHITE);
		img.setFont(GameValue.display_font);
		int x0=30,y0=70,yh=20+8;
		img.drawString("生命值", x0,y0);
		img.drawString("法术值", x0,y0+yh);
		
		/**
		 * 分别是生命值和法术值*/
		img.drawRect(x0*3+8-1, y0-15-1, 150+1, 15+1);
		img.drawRect(x0*3+8-1, y0+yh-15-1, 150+1, 15+1);
		
		img.setColor(Color.GREEN);
		int hp_width=(int)(((double)(Hero.HP_NOW)/Hero.HP_ALL)*150);
		img.fillRect(x0*3+8, y0-15, hp_width, 15);
		
		img.setColor(Color.BLUE);
		int mp_width=(int)(((double)(Hero.MP_NOW)/Hero.MP_ALL)*150);
		img.fillRect(x0*3+8, y0+yh-15, mp_width, 15);
		
		img.setColor(Color.WHITE);
		img.drawString(Hero.HP_NOW+"/"+Hero.HP_ALL,x0*3+8-1+45, y0);
		img.drawString(Hero.MP_NOW+"/"+Hero.MP_ALL,x0*3+8-1+45, y0+yh);
		
		for(int i=0;i<monsters.size();i++) {
			Monster m=monsters.get(i);
			if(m.islive) {
				if(m.left) {
					img.drawImage(m.imgs_left[m.index],m.mX,m.Y,70,70,this);
				}
				else if(m.right) {
					img.drawImage(m.imgs_right[m.index],m.mX,m.Y,70,70,this);
				}
			}
		}
		
		/**
		 * 如果主角处于被攻击状态*/
		if(Hero.ishurted) {
			
		}
		/**
		 * 主角昏迷了*/
		else if(Hero.isfall) {
			
		}
		else {
			/**
			 * 构建主角静态动作*/
			if(Hero.left && !Hero.jump && !Hero.walk && !Hero.attack && !Hero.skill0_attack) {
				img.drawImage(Hero.stand_left[sli],Hero.X,Hero.Y,this);
			}
			
			if(Hero.right && !Hero.jump && !Hero.walk && !Hero.attack && !Hero.skill0_attack) {
				img.drawImage(Hero.stand_right[sri],Hero.X,Hero.Y,this);
			}
			
			/**
			 * 主角跳动作，包含跳击*/
			if(Hero.jump) {
				if(Hero.attack) {
					if(Hero.left) {
						img.drawImage(Hero.jump_attack_left[jli],Hero.X,Hero.jumpY,this);
					}
					if(Hero.right) {
						img.drawImage(Hero.jump_attack_right[jri],Hero.X,Hero.jumpY,this);
					}
				}
				else {
					if(Hero.left) {
						img.drawImage(Hero.jump_left[jli],Hero.X-7,Hero.jumpY,this);
					}
					if(Hero.right) {
						img.drawImage(Hero.jump_right[jri],Hero.X+7,Hero.jumpY,this);
					}
				}
			}
			
			/**
			 * 主角非跳动作，包含行走和普通攻击*/
			else {
				if(Hero.attack) {
					if(Hero.left) {
						img.drawImage(Hero.attack_left[ali],Hero.X-50,Hero.Y,this);
					}
					if(Hero.right) {
						img.drawImage(Hero.attack_right[ari],Hero.X+50,Hero.Y,this);
					}
				}
				else {
					if(Hero.walk) {
						if(Hero.left) {
							img.drawImage(Hero.walk_left[wli],Hero.X,Hero.Y,this);
						}
						if(Hero.right) {
							img.drawImage(Hero.walk_right[wri],Hero.X,Hero.Y,this);
						}
					}
					/**技能释放优先级最低*/
					else {
						if(Hero.skill0_attack) {
							if(Hero.left) {
								img.drawImage(Hero.skill0_attack_left[s0i],Hero.X-40,Hero.Y-75,this);
							}
							if(Hero.right) {
								img.drawImage(Hero.skill0_attack_right[s0i],Hero.X-10,Hero.Y-80,this);
							}
						}
					}
				}
			}
		}
		
		img.dispose();
		g.drawImage(ImageBuffer,0,0,this);
		
		//super.paint(g);
		
	}
	
	class ActionThread implements Runnable{
		
		public ActionThread() {
			// TODO Auto-generated constructor stub
			new Thread(this).start();
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(Hero.HP_NOW>0) {
				if(!Hero.ishurted) {
					/**
					 * 非跳起状态*/
					if(!Hero.jump) {
						
						/**
						 * 优先级attack>walk>skill>stand*/
						if(Hero.attack) {
							for(int i=0;i<Hero.attack_right.length;i++) {
								if(Hero.left) {
									ali=i;
								}
								else if(Hero.right) {
									ari=i;
								}
								repaintUI(80);
							}
							ali=0;
							ari=0;
							Hero.attack=false;
						}
						else {
							/**
							 * 行走状态*/
							if(Hero.walk) {
								for(int i=0;i<Hero.walk_right.length;i++) {
									/**如果提前释放AD键或者按了空格键则立刻停止*/
									if(!Hero.walk || Hero.jump) {
										break;
									}
									if(Hero.left) {
										wli=i;
										Hero.X-=Hero.step;
										if(Hero.X<=0) {
											/********更换场景********/
											if(bgindex!=0) {
												bgindex--;
												Hero.X=GameValue.Width-105;
												AllClear();
												repaint();
											}
											
											else{
												Hero.X=0;
											}
										}
									}
									else if(Hero.right) {
										wri=i;
										Hero.X+=Hero.step;
										if(Hero.X>=(GameValue.Width-80)) {
											/********更换场景********/
											if(bgindex!=GameValue.bgimgs.length-1) {
												bgindex++;
												Hero.X=0;
												AllClear();
												repaint();
											}
											else{
												Hero.X=GameValue.Width-80;
											}
										}
									}
									repaintUI(100);
								}
							}
							
							/**
							 * 静止状态*/
							else {
								/**技能攻击*/
								if(Hero.skill0_attack) {
									/**首先检查MP是否足够，否则不能释放技能*/
									if(Hero.MP_NOW>=Hero.skill0_mp) {
										Hero.MP_NOW-=Hero.skill0_mp;
										for(int i=0;i<Hero.skill0_attack_right.length;i++) {
											s0i=i;
											repaintUI(80);
										}
									}
									else if(Hero.MP_NOW<=0) {
										Hero.MP_NOW=0;
										repaint();
									}
									s0i=0;
									Hero.skill0_attack=false;
								}
								
								else {
									for(int i=0;i<Hero.stand_right.length;i++) {
										/**如果按了AD键或者按了空格键则立刻停止*/
										if(Hero.walk || Hero.jump) {
											break;
										}
										if(Hero.left) {
											sli=i;
										}
										else if(Hero.right) {
											sri=i;
										}
										if(Hero.X>=(GameValue.Width-101)) {
											Hero.X=GameValue.Width-101;
										}
										repaintUI(100);
									}
								}
							}
						}
					}
					
					/**
					 * 跳起状态*/
					else if(Hero.jump) {
						for(int i=0;i<Hero.jump_right.length;i++) {
							
							if(Hero.left) {
								jli=i;
							}
							else if(Hero.right) {
								jri=i;
							}
							
							if(KeyWork.pressA) {
								Hero.X-=Hero.step+5;
								if(Hero.X<=0) {
									Hero.X=0;
								}
							}
							else if(KeyWork.pressD) {
								Hero.X+=Hero.step+5;
								if(Hero.X>=(GameValue.Width-103)) {
									Hero.X=GameValue.Width-103;
								}
							}
							
							if(i>=2 && i<=7) {
								Hero.jumpY-=12;
							}
							if(i>=9 && i<=14) {
								Hero.jumpY+=12;
							}
							repaintUI(80);
						}
						jli=0;
						jri=0;
						Hero.jump=false;
						Hero.attack=false;
						repaint();
					}
					
					//System.out.print("");
				}
				else {
					try {
						Thread.sleep(200);
						Hero.ishurted=false;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	/**刷新界面*/
	public void repaintUI(int times) {
		this.repaint();
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 消灭所有妖怪<br>
	 * 使妖怪再生*/
	public static void AllClear() {
		for(Monster m:monsters) {
			m.islive=false;
		}
		monsters.clear();
	}
}