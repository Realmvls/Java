package com.yunsitech;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestFrame2 extends JFrame implements ActionListener {

	
	private JButton btn;
	private JButton btn2;
	private JTextArea area;//文本域
	
	public TestFrame2(int width,int height){
//		f = new JFrame("演示JFrame");
		this.setTitle("演示JFrame");
		this.setSize(width,height);
		//构造按钮
		btn = new JButton("按钮");
		btn2 = new JButton("按钮2");
		//注册事件
		btn.addActionListener(this);
		btn2.addActionListener(this);
		
		
		//添加按钮到JPanel中（Jpanel默认是FlowLayout布局管理器）
		JPanel panel = new JPanel();
		panel.add(btn);
		panel.add(btn2);
		
		//组织一个文本域		
		area = new JTextArea();
		//为JTextArea添加滚动条
		JScrollPane jsp = new JScrollPane(area);
		
		
		//再把panel放入f中的南边（页面下面）
		this.getContentPane().add(panel,BorderLayout.SOUTH);
		this.getContentPane().add(jsp,BorderLayout.CENTER);
		
		//界面居中
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//重写ActionListener中的抽象方法
	public void actionPerformed(ActionEvent ae){
		Object source = ae.getSource();
		if(source==btn){
			System.out.println("按钮1被点击了。。。");
			area.append("按钮1被点击了。。。\n");
		}
		else if(source==btn2){
			System.out.println("按钮2被点击了。。。");
			area.append("按钮2被点击了。。。\n");
		}
	}
	
	public static void main(String[] args) {
		TestFrame2 tf = new TestFrame2(500,300);
		
	}
}
