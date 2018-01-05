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
	Fish[] fishs = new Fish[9];//ǰ0-9��13 14
	Net net = null;
	int score = 0;
	int fontsize = 20;
	Font font = new Font("����", Font.BOLD, fontsize);

	Pool() throws IOException
	{
		background = ImageIO.read(getClass().getResourceAsStream("/images/bg.jpg"));
		//����ͼƬ��ȡ
		for (int i = 0; i < 9; i++) 
			//���β���0-9����㣬0-9ÿ�����Ӧ����һ���߳�
			//ÿ������߳��Լ��ı�ͼƬ�Լ�����
			//���ն���paint����
		{
			fish = new Fish("fish0" + (i + 1));
			fishs[i] = fish;
			fish.start();//����fish.run
		}
	}

	public void paint(Graphics g) // paint�Զ����ã�����Ϊ����graphics�е�ͼƬ
	{
		g.drawImage(background, 0, 0, null);// ��������ͼ
		for (int i = 0; i < fishs.length; i++)// ���������������е���
		{
			Fish tempfish = fishs[i];
			g.drawImage(tempfish.fishimage, tempfish.x, tempfish.y, null);
		}
		if (net.show) //�����Ҫ��ʾ�����򻭳���
		{
			g.drawImage(net.netimage, net.x - net.width / 2, net.y - net.height
					/ 2, null);
		}
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("SCORE:", 10, 20);
		g.setColor(Color.red);
		g.drawString("      " + score, 10, 20);
		// �ɼ���ʾ
	}

	public void action() throws Exception 
	{

		net = new Net();
		// ����¼��ļ���
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

			// ������ƶ�ʱ��ִ��
			public void mouseMoved(MouseEvent e) 
			{
				// MouseEvent ����¼�:����¼�����ʱ��ص�����
				net.x = e.getX();
				net.y = e.getY();
				//�������꣬������ʾ���Ѿ��жϲ���
			}

			public void mousePressed(MouseEvent e) 
			{
				catchFish();// catch:ץ�� ����갴�µ�ʱ�򣬽���ץ�����
			}

		};
		this.addMouseListener(m); // �������pool������궯��
		this.addMouseMotionListener(m);
		net.show = true;// ���Դ���

		while (true) //��ѭ����Ϸ�ٴν���
		{
			repaint();//�ػ����Զ�����paint()
			try 
			{
				Thread.sleep(80);//�߳�����80ms
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

	protected void catchFish()
	{
		// ���ڲ������ķ�Χ�ڣ��ڵĻ���������ʧ
		for (int i = 0; i < fishs.length; i++) 
		{
			fish = fishs[i];
			if (fish.contains(net.x, net.y)) 
			{// �ж��ڲ������ķ�Χ
				if((Math.random()*100)+1>=10){
				fish.getOut();
				score += fish.width / 10;//�ӷ�
			}}
		}
	}

}
