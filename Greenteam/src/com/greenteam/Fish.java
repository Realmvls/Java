package com.greenteam;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

class Fish extends Thread //�߳�
{
	int x, y, index = 0, width, height, step;

	BufferedImage fishimage;
	BufferedImage[] fishimages = new BufferedImage[9];
	Random r;

	Fish(String fishname) throws IOException
	{
		for (int i = 0; i < 9; i++) 
		{
			BufferedImage tempfishimage = ImageIO.read
			(getClass().getResourceAsStream("/images/" + fishname + "_0" + (i + 1) + ".png"));
			fishimages[i] = tempfishimage;
		}
		fishimage = fishimages[index];
		r = new Random();// ��д���ֱ�ʾ����int��Χ�ڵ�һ������
		width = fishimage.getWidth();
		height = fishimage.getHeight();
		x = 790;
		y = r.nextInt(470 - height);//�����������λ��
		step = r.nextInt(4) + 1;//�����������
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(50);//�߳�����50ms
				index++;
				fishimage = fishimages[index % fishimages.length];
				// ����Ҫ��������Ҫ�ı�ͼƬ
				x = x - step;
				if (x <= (0-this.width) || y <= 0 || y >= 480)
					//������Ļ��Χ
					//����Ҫ����������ĳ���
					getOut();
			} catch (Exception e) {
			}
		}
	}

	// ��飨net.x,net.y���������Ƿ�����ķ�Χ֮��
	public boolean contains(int netx, int nety) {
		int dx = netx - x;
		int dy = nety - y;
		return dx >= 0 && dx <= width && dy >= 0 && dy <= height;
	}

	void getOut()//ɾ�����㣬�����¼�����
	{
		Random r = new Random(); 
		x = 790;
		y = r.nextInt(470 - height);
		step = r.nextInt(4) + 1;
	}
}