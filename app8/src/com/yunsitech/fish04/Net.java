package com.yunsitech.fish04;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ץ�����
 * 
 * @author user
 * 
 */
public class Net {

	private BufferedImage netImg;// ��Ӧ��ͼƬ
	// ͼƬ����Ϣ
	private int netX;
	private int netY;
	private int netWidth;
	private int netHeight;// �ع�
	private boolean show;//����ͼƬ��ʾ���true��ʾ��false����

	public Net() {
		// �ȳ�ʼ������
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
		//Ĭ���������ص�
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
	
	//��������
	public void hideNet(){
		show = false;
	}
	//��ʾ����
	public void showNet(){
		show = true;
	}
	
	//�������Ƿ���ʾ
	public boolean isShow(){
		return show;
	}
	
	//�ƶ���
	public void move(int x,int y){
		netX = x;
		netY = y;
	}

	//ץ��
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
