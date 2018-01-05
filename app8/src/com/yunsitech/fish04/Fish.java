package com.yunsitech.fish04;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * ��
 * @author user
 *
 */
public class Fish implements Runnable{

	private BufferedImage[] fishImages;//���ͼƬ����ͬ��״��

	private BufferedImage fishImg;//��ǰ���ͼƬ
	private int fishX;//���x����
	private int fishY;
	private int fishWidth;//���
	private int fishHeight;//�߶�
	private int currFishIndex;//��ǰ���Ӧ��ͼƬ�±�
	private Random rand = new Random();//����������Ĺ���
	private int step;//�ƶ����ٶȣ�������
	
	public Fish(String fishName){
		//��ȡ���10����״��ͼƬ
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
		//��ʼ����һ����
		currFishIndex = 0;
		fishImg = fishImages[currFishIndex];
		//��ȡ���Ļ�����Ϣ(���滭ʹ�õģ�
		fishWidth = fishImg.getWidth();//BuffereImage int getWidth()����ͼƬ���
		fishHeight = fishImg.getHeight();
		fishX = 800;
		fishY = rand.nextInt(600-fishWidth);//��һ��ʼ��y�±������
		//�����ٶȣ��������2-10
		step = rand.nextInt(8)+2;
		
	}
	
	//getter�����Ǹ�FishPoolʹ�ã���ΪFishPool
	//Ҫ��ÿһ����
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
	
	//��дRunnable�еķ���
	public void run(){
		while(true){
			//1.�ı�fishX
			fishX-=step;
			
			//2.�л�ͼƬ
			fishImg = fishImages[++currFishIndex%fishImages.length];
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//3.���fishX��Խ��Ļ����ô����������
			if(fishX<-fishWidth){
				disappear();
			}
		}
	}
	//��������
	public void disappear(){
		fishX= 800;
		fishY = rand.nextInt(600-fishHeight);
		step = rand.nextInt(8)+2;
		
	}
	
}
