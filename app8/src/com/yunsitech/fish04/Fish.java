package com.yunsitech.fish04;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 鱼
 * @author user
 *
 */
public class Fish implements Runnable{

	private BufferedImage[] fishImages;//多个图片（不同形状）

	private BufferedImage fishImg;//当前鱼的图片
	private int fishX;//鱼的x坐标
	private int fishY;
	private int fishWidth;//宽度
	private int fishHeight;//高度
	private int currFishIndex;//当前鱼对应的图片下标
	private Random rand = new Random();//产生随机数的工具
	private int step;//移动的速度（步长）
	
	public Fish(String fishName){
		//读取鱼的10种形状的图片
		fishImages = new BufferedImage[10];
		for(int i=0;i<fishImages.length;i++){
			try {
				fishImages[i] = 
					ImageIO.read(
						new File("imgs/"+fishName+"_0"+i+".png")
					);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//初始化第一条鱼
		currFishIndex = 0;
		fishImg = fishImages[currFishIndex];
		//获取他的基本信息(给绘画使用的）
		fishWidth = fishImg.getWidth();//BuffereImage int getWidth()返回图片宽度
		fishHeight = fishImg.getHeight();
		fishX = 800;
		fishY = rand.nextInt(600-fishWidth);//鱼一开始的y下标随机的
		//对于速度，随机产生2-10
		step = rand.nextInt(8)+2;
		
	}
	
	//getter方法是给FishPool使用，因为FishPool
	//要画每一条鱼
	public int getFishX(){
		return fishX;
	}
	public int getFishY(){
		return fishY;
	}
	public int getFishWidth(){
		return fishWidth;
	}
	public int getFishHeight(){
		return fishHeight;
	}
	public BufferedImage getFishImage(){
		return fishImg;
	}
	
	//重写Runnable中的方法
	public void run(){
		while(true){
			//1.改变fishX
			fishX-=step;
			
			//2.切换图片
			fishImg = fishImages[++currFishIndex%fishImages.length];
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//3.如果fishX超越屏幕，那么重置这条鱼
			if(fishX<-fishWidth){
				disappear();
			}
		}
	}
	//让鱼重置
	public void disappear(){
		fishX= 800;
		fishY = rand.nextInt(600-fishHeight);
		step = rand.nextInt(8)+2;
		
	}
	
}
