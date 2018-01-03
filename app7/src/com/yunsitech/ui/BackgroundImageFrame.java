package com.yunsitech.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * 捕鱼那个例子中的背景图片如何在JFrame中显示出来
 * 		提供的方式：使用绘画技术把图片给“画”到JFrame中
 * @author user
 *
 */
public class BackgroundImageFrame extends JFrame {

	public BackgroundImageFrame(int width,int height){
		setTitle("捕鱼app");
		setSize(width,height);
		setLocationRelativeTo(null);	
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//组件都有一个方法叫做void paint(Graphics g){...}
	//重写paint
	public void paint(Graphics g){
		super.paint(g);//继续调用父类JFrame中的paint
		
		try {
			//1.读取那个图片bg.jpg
			BufferedImage bgImg =ImageIO.read(new File("imgs/bg.jpg")); 
			//2.使用Graphics对象中的相关绘图方法，
			//把bg.jpg给绘画到JFrame上面
			int imgX = 0;
			int imgY = 0;
			int imgWidth = this.getWidth();//JFrame的宽度
			int imgHeight = this.getHeight();//JFrame的高度
			g.drawImage(bgImg,imgX,imgY,imgWidth,imgHeight,null);
			
			//继续再画一条鱼
			BufferedImage fishImg = ImageIO.read(new File("imgs/fish13_00.png"));
			imgX =400;
			imgY = 300;
			imgWidth = fishImg.getWidth();
			imgHeight = fishImg.getHeight();
			g.drawImage(fishImg,imgX,imgY,imgWidth,imgHeight,null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		BackgroundImageFrame b = new BackgroundImageFrame(800,600);
	}
}
