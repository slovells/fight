package com.slovell.fight.main;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.slovell.fight.panel.MainFrame;

/***
 * 游戏入口*/
public class FightGameLaunch {
	
	private static MainFrame main;
	
	public static MainFrame getMainFrame() {
		return main;
	}
	
	public static void main(String[] args) {
		setLookAndFeel();
		main=new MainFrame();
		main.display(true);
	}
	
	/**设置LookAndFeel**/
	public static void setLookAndFeel() {
		/*LookAndFeel设置窗体风格*/
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	//当前系统风格
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(UnsupportedLookAndFeelException ex1){
			JOptionPane.showMessageDialog(null,"该设备不支持nimbu格式，将切换至当前系统风格！","错误", JOptionPane.ERROR_MESSAGE);
		 }
		 catch(ClassNotFoundException ex2){
			JOptionPane.showMessageDialog(null,"该设备未找到nimbu格式，将切换至当前系统风格！","错误", JOptionPane.ERROR_MESSAGE);
		 }
		 catch(InstantiationException ex3){
			JOptionPane.showMessageDialog(null,"实例化异常，将切换至当前系统风格！","错误", JOptionPane.ERROR_MESSAGE);
		 }
		 catch(IllegalAccessException ex4){
			JOptionPane.showMessageDialog(null,"格式非法，将切换至当前系统风格！","错误", JOptionPane.ERROR_MESSAGE);
		 }
	}
}