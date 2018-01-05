package com.greenteam;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

class Fish extends Thread //线程
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
		r = new Random();// 不写数字表示的是int范围内的一个数字
		width = fishimage.getWidth();
		height = fishimage.getHeight();
		x = 790;
		y = r.nextInt(470 - height);//随机产生出生位置
		step = r.nextInt(4) + 1;//随机产生步长
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(50);//线程休眠50ms
				index++;
				fishimage = fishimages[index % fishimages.length];
				// 现在要动，所以要改变图片
				x = x - step;
				if (x <= (0-this.width) || y <= 0 || y >= 480)
					//超出屏幕范围
					//其中要考虑鱼自身的长度
					getOut();
			} catch (Exception e) {
			}
		}
	}

	// 检查（net.x,net.y）的坐标是否在鱼的范围之内
	public boolean contains(int netx, int nety) {
		int dx = netx - x;
		int dy = nety - y;
		return dx >= 0 && dx <= width && dy >= 0 && dy <= height;
	}

	void getOut()//删除此鱼，并重新加入鱼
	{
		Random r = new Random(); 
		x = 790;
		y = r.nextInt(470 - height);
		step = r.nextInt(4) + 1;
	}
}