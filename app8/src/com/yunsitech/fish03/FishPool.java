package com.yunsitech.fish03;

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
 *	支持鱼的x坐标变动，以至于重新绘画页面的时候
 *	鱼在向左边游动
 */
public class FishPool extends JPanel implements Runnable{
	
	private BufferedImage bgImg;//背景图片
	private int score;//捕鱼的得分
	
	//一些鱼（Fish类型的对象）
	private Fish[] fishes;//多条鱼

	
	public FishPool(){
		
		//初始化鱼
		fishes = new Fish[20];
		for(int i=1;i<=9;i++){
			fishes[i-1] = new Fish("fish0"+i);
			fishes[i+8] = new Fish("fish0"+i);
		}
		fishes[18] = new Fish("fish13");
		fishes[19] = new Fish("fish14");
		
		//初始化图片(读取磁盘上的图片）
		try {
			bgImg = ImageIO.read(new File("imgs/bg.jpg"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//!!!鱼池让鱼自身动起来（Fish内部要自己的改变X轴，以及切换图片）
		//参照鱼池作为线程里面的逻辑
		
		//把自己当作线程给启动
		//(不停的改变与的x坐标，与此同时不同的重绘页面)
		new Thread(this).start();
		
	}
	
	//重写JPanel类中的paint方法
	//paint方法专门用来绘制界面的（原本JFrame中自己会调用）
	public void paint(Graphics g){
		//把背景图片和鱼图片给画出来
		g.drawImage(bgImg,0,0,this.getWidth(),this.getHeight(),null);
		
		//试图把20条鱼给画出来
		for(Fish fish : fishes){
			
			g.drawImage(fish.getFishImage(),
					fish.getFishX(),
					fish.getFishY(),
					fish.getFishWidth(),
					fish.getFishHeight(),
					null);
		}
		
		//把分数那个文字给画上去
		//设置后续画字符串的颜色
		g.setColor(Color.WHITE);//r(red)g(green)b(blue)
		//设置大小
		g.setFont(new Font("宋体",Font.BOLD,30));
		g.drawString("分数："+score,30,50);
		
	}
	
	//重写Runnable中的run方法
	public void run()
	{
		//1让所有的鱼动起来（因为每一条鱼就是一个线程）
		for(Fish fish: fishes){
			new Thread(fish).start();
		}
		//2.不停的重绘页面
		while(true){
			this.repaint();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
