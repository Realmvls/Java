package com.yunsitech.fish01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 鱼池子，里面好多鱼啊
 * @author user
 *
 */
public class FishPool extends JPanel{
	
	private BufferedImage bgImg;//背景图片
	private BufferedImage fishImg;//鱼的图片
	private int score;//捕鱼的得分
	
	public FishPool(){
		//初始化图片(读取磁盘上的图片）
		try {
			bgImg = ImageIO.read(new File("imgs/bg.jpg"));
			fishImg = ImageIO.read(new File("imgs/fish13_00.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//重写JPanel类中的paint方法
	//paint方法专门用来绘制界面的（原本JFrame中自己会调用）
	public void paint(Graphics g){
		//把背景图片和鱼图片给画出来
		g.drawImage(bgImg,0,0,this.getWidth(),this.getHeight(),null);
		g.drawImage(fishImg,300,200,fishImg.getWidth(),fishImg.getHeight(),null);
		
		//把分数那个文字给画上去
		//设置后续画字符串的颜色
		g.setColor(Color.WHITE);//r(red)g(green)b(blue)
		//设置大小
		g.setFont(new Font("宋体",Font.BOLD,30));
		g.drawString("分数："+score,30,50);
		
	}
}
