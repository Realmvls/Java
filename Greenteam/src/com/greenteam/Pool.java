package com.greenteam;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Pool extends JPanel 
{
	BufferedImage background = null;
	Fish fish = null;;
	Fish[] fishs = new Fish[9];//前0-9和13 14
	Net net = null;
	int score = 0;
	int fontsize = 20;
	Font font = new Font("楷体", Font.BOLD, fontsize);

	Pool() throws IOException
	{
		background = ImageIO.read(getClass().getResourceAsStream("/images/bg.jpg"));
		//背景图片读取
		for (int i = 0; i < 9; i++) 
			//依次产生0-9类的鱼，0-9每条鱼对应产生一个线程
			//每个鱼的线程自己改变图片以及坐标
			//最终都被paint画出
		{
			fish = new Fish("fish0" + (i + 1));
			fishs[i] = fish;
			fish.start();//启动fish.run
		}
	}

	public void paint(Graphics g) // paint自动调用，功能为画出graphics中的图片
	{
		g.drawImage(background, 0, 0, null);// 画出背景图
		for (int i = 0; i < fishs.length; i++)// 画出鱼数组中所有的鱼
		{
			Fish tempfish = fishs[i];
			g.drawImage(tempfish.fishimage, tempfish.x, tempfish.y, null);
		}
		if (net.show) //如果需要显示网，则画出网
		{
			g.drawImage(net.netimage, net.x - net.width / 2, net.y - net.height
					/ 2, null);
		}
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("SCORE:", 10, 20);
		g.setColor(Color.red);
		g.drawString("      " + score, 10, 20);
		// 成绩显示
	}

	public void action() throws Exception 
	{

		net = new Net();
		// 鼠标事件的监听
		MouseAdapter m = new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e) 
			{
				net.show = true;
			}

			public void mouseExited(MouseEvent e) 
			{
				net.show = false;
			}

			// 在鼠标移动时候执行
			public void mouseMoved(MouseEvent e) 
			{
				// MouseEvent 鼠标事件:鼠标事件发生时间地点人物
				net.x = e.getX();
				net.y = e.getY();
				//网的坐标，用于显示，已经判断捕鱼
			}

			public void mousePressed(MouseEvent e) 
			{
				catchFish();// catch:抓鱼 在鼠标按下的时候，进行抓鱼操作
			}

		};
		this.addMouseListener(m); // 处理这个pool对象鼠标动作
		this.addMouseMotionListener(m);
		net.show = true;// 调试代码

		while (true) //死循环游戏再次进行
		{
			repaint();//重画，自动调用paint()
			try 
			{
				Thread.sleep(80);//线程休眠80ms
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

	protected void catchFish()
	{
		// 鱼在不在网的范围内？在的话就让鱼消失
		for (int i = 0; i < fishs.length; i++) 
		{
			fish = fishs[i];
			if (fish.contains(net.x, net.y)) 
			{// 判断在不在网的范围
				if((Math.random()*100)+1>=10){
				fish.getOut();
				score += fish.width / 10;//加分
			}}
		}
	}

}
