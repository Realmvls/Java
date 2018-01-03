package com.yunsitech;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestFrame {

	public static void main(String[] args) {
		JFrame f = new JFrame("演示JFrame");
		//设置窗体大小
		int width = 500;
		int height=380;
		int x = 100;
		int y = 100;
		f.setSize(width,height);
		//f.setBounds(x, y, width, height);
		
		//可以让窗口屏幕居中显示
		f.setLocationRelativeTo(null);
		
		//构造一个按钮
		JButton btn = new JButton("按钮");
		JButton btn2 = new JButton("按钮2");
		
		//为按钮添加点击事件
		MyActionListener listener = new MyActionListener();
		btn.addActionListener(listener);
		btn2.addActionListener(listener);
		//void addActionListener(ActionListener)
		
		//把按钮“安放"在JFrame上面
		//Container c = f.getContentPane();//获取JFrame的容器引用
		//c.add(btn,BorderLayout.EAST);//试图添加到东南西北中的中间位置
		
		//换一个布局管理器
		f.setLayout(new FlowLayout());
		f.getContentPane().add(btn);
		f.getContentPane().add(btn2);
		
		//让他显示出来
		f.setVisible(true);
		//让窗口右上角的关闭按钮（有效）
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
