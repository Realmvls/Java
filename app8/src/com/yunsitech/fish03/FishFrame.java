package com.yunsitech.fish03;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;

public class FishFrame extends JFrame{

	private FishPool fishPool = null;
	
	public FishFrame(){
		this(800,600);
	}
	public FishFrame(int width,int height){
		//设置界面的标题
		this.setTitle("捕鱼应用");
		//设置界面宽度和高度
		this.setSize(width,height);
		//让界面屏幕居中显示
		this.setLocationRelativeTo(null);
		
		//初始化鱼池子（JPanel）
		fishPool = new FishPool();
		
		Container c = this.getContentPane();
		c.add(fishPool,BorderLayout.CENTER);
		
		//让关闭按钮可以结束程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示界面
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		FishFrame f = new FishFrame();
	}
}
