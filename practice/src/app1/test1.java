package app1;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("��ʾJFrame");
		int width = 500;
		int height = 500;
		int x = 100;
		int y = 100;
		f.setSize(width,height);
		f.setLocationRelativeTo(null);
		
		JButton btn = new JButton("��ť");
		JButton btn2 = new JButton("��ť2");
		JButton btn3 = new JButton("��ť3");
		JButton btn4 = new JButton("��ť4");
		JButton btn5 = new JButton("��ť5");
		
		MyActionListener listener = new MyActionListener();
		btn.addActionListener(listener);
		btn2.addActionListener(listener);
		btn3.addActionListener(listener);
		btn4.addActionListener(listener);
		btn5.addActionListener(listener);
		f.setLayout(new FlowLayout());
		
	
		f.getContentPane().add(btn);
		f.getContentPane().add(btn2);
		f.getContentPane().add(btn3);
		f.getContentPane().add(btn4);
		f.getContentPane().add(btn5);
		
		f.setVisible(true);
		
//		TODO
		
		
	}

}