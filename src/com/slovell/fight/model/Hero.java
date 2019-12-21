package com.slovell.fight.model;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

import com.slovell.fight.main.FightGameLaunch;

public class Hero {
	/**
	 * 角色的基本属性：生命值，法术值*/
	public static int HP_NOW=100,HP_ALL=100,MP_NOW=120,MP_ALL=120;
	
	/**
	 * 角色当前所在位置X和Y，跳起时所用Y*/
	public static int X=50,Y=400,jumpY=Y-52;

	/**
	 * 角色是否被攻击，角色是否晕眩，角色朝左或朝右，角色是否跳起，角色是否行走，是否攻击，技能攻击（一技能）*/
	public static boolean ishurted=false,isfall=false,left=false,right=true,jump=false,walk=false,
			attack=false,skill0_attack=false;
	
	/**
	 * 定义普通攻击的伤害，跳击伤害和一技能的耗MP和伤害*/
	public static int attack_hp=10,jump_attack_hp=15,skill0_mp=15,skill0_hp=20;
	
	/**
	 * 角色步长*/
	public static int step=15;
	
	/**
	 * 角色图片素材-左站*/
	public static Image[] stand_left= {
			Toolkit.getDefaultToolkit().getImage("img/role/stand-left/stand01.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/stand-left/stand02.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/stand-left/stand03.png")
	};
	
	/**
	 * 角色图片素材-左跳*/
	public static Image[] jump_left= {
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/0.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/1.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/2.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/3.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/4.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/5.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/6.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/7.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/8.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/9.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/10.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/11.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/12.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/13.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/14.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/15.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/16.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/17.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/18.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-left/19.png")
	};
	
	/**
	 * 角色图片素材-左走*/
	public static Image[] walk_left= {
			Toolkit.getDefaultToolkit().getImage("img/role/walk-left/0.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/walk-left/1.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/walk-left/2.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/walk-left/3.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/walk-left/4.png")
	};
	
	/**
	 * 角色图片素材-左攻击*/
	public static Image[] attack_left= {
			Toolkit.getDefaultToolkit().getImage("img/role/attack-left/0.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/attack-left/1.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/attack-left/2.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/attack-left/3.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/attack-left/4.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/attack-left/5.png")
	};
	
	/**
	 * 角色图片素材-左跳击*/
	public static Image[] jump_attack_left= {
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/0.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/1.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/2.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/3.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/4.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/5.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/6.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/7.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/8.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/9.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/10.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/11.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/12.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/13.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/14.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/15.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/16.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/17.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/18.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-left/19.png")
	};
	
	/**
	 * 角色图片素材-一技能动画-左*/
	public static Image[] skill0_attack_left= {
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/0.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/1.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/2.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/3.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/4.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/5.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/6.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/7.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/8.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/9.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/10.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/11.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/12.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/13.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/14.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/15.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/16.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/17.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/18.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/19.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/left/20.png")
	};
	
	
	/**************************************************************************/
	
	/**
	 * 角色图片素材-右站*/
	public static Image[] stand_right= {
			Toolkit.getDefaultToolkit().getImage("img/role/stand-right/stand01.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/stand-right/stand02.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/stand-right/stand03.png")
	};
	
	/**
	 * 角色图片素材-右跳*/
	public static Image[] jump_right= {
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/0.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/1.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/2.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/3.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/4.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/5.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/6.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/7.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/8.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/9.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/10.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/11.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/12.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/13.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/14.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/15.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/16.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/17.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/18.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-right/19.png")
	};
	
	/**
	 * 角色图片素材-右走*/
	public static Image[] walk_right= {
			Toolkit.getDefaultToolkit().getImage("img/role/walk-right/0.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/walk-right/1.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/walk-right/2.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/walk-right/3.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/walk-right/4.png")
	};
	
	/**
	 * 角色图片素材-右攻击*/
	public static Image[] attack_right= {
			Toolkit.getDefaultToolkit().getImage("img/role/attack-right/0.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/attack-right/1.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/attack-right/2.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/attack-right/3.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/attack-right/4.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/attack-right/5.png")
	};
	
	/**
	 * 角色图片素材-右跳击*/
	public static Image[] jump_attack_right= {
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/0.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/1.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/2.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/3.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/4.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/5.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/6.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/7.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/8.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/9.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/10.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/11.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/12.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/13.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/14.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/15.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/16.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/17.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/18.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/jump-attack-right/19.png")
	};
	
	/**
	 * 角色图片素材-一技能动画-右*/
	public static Image[] skill0_attack_right= {
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/0.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/1.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/2.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/3.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/4.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/5.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/6.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/7.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/8.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/9.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/10.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/11.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/12.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/13.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/14.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/15.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/16.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/17.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/18.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/19.png"),
			Toolkit.getDefaultToolkit().getImage("img/role/skills/0/right/20.png")
	};
	
	public static void attacked(int atk) {
		ishurted=true;
		HP_NOW-=atk;
		
		if(HP_NOW<0) {
			HP_NOW=0;
			FightGameLaunch.getMainFrame().repaint();
			int choose=JOptionPane.showConfirmDialog(null,"游戏结束，是否退出？",
					"退出",JOptionPane.YES_NO_OPTION);
			if(choose==0){
				System.exit(0);
			}
			else
				System.out.println("重开");
		}
	}

}