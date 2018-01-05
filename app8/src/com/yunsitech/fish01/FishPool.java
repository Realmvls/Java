package com.yunsitech.fish01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * ����ӣ�����ö��㰡
 * @author user
 *
 */
public class FishPool extends JPanel{
	
	private BufferedImage bgImg;//����ͼƬ
	private BufferedImage fishImg;//���ͼƬ
	private int score;//����ĵ÷�
	
	public FishPool(){
		//��ʼ��ͼƬ(��ȡ�����ϵ�ͼƬ��
		try {
			bgImg = ImageIO.read(new File("imgs/bg.jpg"));
			fishImg = ImageIO.read(new File("imgs/fish13_00.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//��дJPanel���е�paint����
	//paint����ר���������ƽ���ģ�ԭ��JFrame���Լ�����ã�
	public void paint(Graphics g){
		//�ѱ���ͼƬ����ͼƬ��������
		g.drawImage(bgImg,0,0,this.getWidth(),this.getHeight(),null);
		g.drawImage(fishImg,300,200,fishImg.getWidth(),fishImg.getHeight(),null);
		
		//�ѷ����Ǹ����ָ�����ȥ
		//���ú������ַ�������ɫ
		g.setColor(Color.WHITE);//r(red)g(green)b(blue)
		//���ô�С
		g.setFont(new Font("����",Font.BOLD,30));
		g.drawString("������"+score,30,50);
		
	}
}
