package com.greenteam;

import javax.swing.JFrame;

import com.greenteam.Pool;

public class Fishlord 
{

	public static void main(String[] args) throws Exception 
	{
		JFrame frame = new JFrame("捕鱼达人");
		Pool pool = new Pool();
		frame.add(pool);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口时关闭程序
		frame.setSize(800, 480);
		frame.setLocationRelativeTo(null);// 设置窗口居中，必须放在setSize之后
		frame.setResizable(false);// 不允许用户改变窗口大小
		frame.setVisible(true);//可见
		pool.action();
	}
}
