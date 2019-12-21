package com.slovell.fight.main;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.slovell.fight.panel.MainFrame;

/***
 * ��Ϸ���*/
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
	
	/**����LookAndFeel**/
	public static void setLookAndFeel() {
		/*LookAndFeel���ô�����*/
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	//��ǰϵͳ���
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(UnsupportedLookAndFeelException ex1){
			JOptionPane.showMessageDialog(null,"���豸��֧��nimbu��ʽ�����л�����ǰϵͳ���","����", JOptionPane.ERROR_MESSAGE);
		 }
		 catch(ClassNotFoundException ex2){
			JOptionPane.showMessageDialog(null,"���豸δ�ҵ�nimbu��ʽ�����л�����ǰϵͳ���","����", JOptionPane.ERROR_MESSAGE);
		 }
		 catch(InstantiationException ex3){
			JOptionPane.showMessageDialog(null,"ʵ�����쳣�����л�����ǰϵͳ���","����", JOptionPane.ERROR_MESSAGE);
		 }
		 catch(IllegalAccessException ex4){
			JOptionPane.showMessageDialog(null,"��ʽ�Ƿ������л�����ǰϵͳ���","����", JOptionPane.ERROR_MESSAGE);
		 }
	}
}