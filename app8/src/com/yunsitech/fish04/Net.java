package com.yunsitech.fish04;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 抓鱼的网
 * 
 * @author user
 * 
 */
public class Net {

	private BufferedImage netImg;// 对应的图片
	// 图片等信息
	private int netX;
	private int netY;
	private int netWidth;
	private int netHeight;// 重构
	private boolean show;//网的图片显示与否，true显示，false隐藏

	public Net() {
		// 先初始化属性
		try {
			netImg = ImageIO.read(new File("imgs/net09.png"));
			netWidth = netImg.getWidth();
			netHeight = netImg.getHeight();
			netX = 0;
			netY = 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//默认网是隐藏的
		show = false;
	}

	public BufferedImage getNetImg() {
		return netImg;
	}

	public int getNetX() {
		return netX;
	}

	public int getNetY() {
		return netY;
	}

	public int getNetWidth() {
		return netWidth;
	}

	public int getNetHeight() {
		return netHeight;
	}
	
	//隐藏起来
	public void hideNet(){
		show = false;
	}
	//显示出来
	public void showNet(){
		show = true;
	}
	
	//测试网是否显示
	public boolean isShow(){
		return show;
	}
	
	//移动网
	public void move(int x,int y){
		netX = x;
		netY = y;
	}

	//抓鱼
	public boolean catchFish(Fish fish){
		int fx = fish.getFishX();
		int fy = fish.getFishY();
		int dx = this.netX-fx;
		int dy = this.netY-fy;
		boolean rst = dx>=0 && dx< fish.getFishWidth()
				&& dy>=0 && dy<fish.getFishHeight();
		return rst;
	}
}
