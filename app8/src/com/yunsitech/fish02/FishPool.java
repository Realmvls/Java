package com.yunsitech.fish02;

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
	
	private BufferedImage fishImg;//鱼的图片
	private BufferedImage[] allFishImgs;//这条鱼的所有图片（不同形态）
	private int score;//捕鱼的得分
	private int fishX;//鱼的x坐标
	private int currFishIndex;//当前鱼对应的图片下标
	
	public FishPool(){
		//初始化图片(读取磁盘上的图片）
		try {
			bgImg = ImageIO.read(new File("imgs/bg.jpg"));
			allFishImgs = new BufferedImage[10];
			for(int i=0;i<allFishImgs.length;i++){
				allFishImgs[i]= ImageIO.read(new File("imgs/fish14_0"+i+".png"));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//初始化fishX的坐标
		fishX = 300;
		
		//获取第一张图片对应的鱼
		currFishIndex = 0;
		fishImg = allFishImgs[currFishIndex];
		
		//把自己当作线程给启动
		//(不停的改变与的x坐标，与此同时不同的重绘页面)
		new Thread(this).start();
		
	}
	
	//重写JPanel类中的paint方法
	//paint方法专门用来绘制界面的（原本JFrame中自己会调用）
	public void paint(Graphics g){
		//把背景图片和鱼图片给画出来
		g.drawImage(bgImg,0,0,this.getWidth(),this.getHeight(),null);
		g.drawImage(fishImg,fishX,200,fishImg.getWidth(),fishImg.getHeight(),null);
		
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
		//主要就是不断的调整鱼的x坐标
		while(true){
			fishX-=2;//每次减少2个像素
			
			//让鱼移动的过程中，切换图片（鱼在游动）
			fishImg= allFishImgs[currFishIndex++%allFishImgs.length];
			
			//重置鱼的x坐标（鱼再次从屏幕的右边出来）
			if(fishX<=(-fishImg.getWidth())){
				fishX = 800;
			}
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
		}
	}
}
