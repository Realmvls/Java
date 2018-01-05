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
 * ����ӣ�����ö��㰡
 * @author user
 *	֧�����x����䶯�����������»滭ҳ���ʱ��
 *	����������ζ�
 */
public class FishPool extends JPanel implements Runnable{
	
	private BufferedImage bgImg;//����ͼƬ
	
	private BufferedImage fishImg;//���ͼƬ
	private BufferedImage[] allFishImgs;//�����������ͼƬ����ͬ��̬��
	private int score;//����ĵ÷�
	private int fishX;//���x����
	private int currFishIndex;//��ǰ���Ӧ��ͼƬ�±�
	
	public FishPool(){
		//��ʼ��ͼƬ(��ȡ�����ϵ�ͼƬ��
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
		//��ʼ��fishX������
		fishX = 300;
		
		//��ȡ��һ��ͼƬ��Ӧ����
		currFishIndex = 0;
		fishImg = allFishImgs[currFishIndex];
		
		//���Լ������̸߳�����
		//(��ͣ�ĸı����x���꣬���ͬʱ��ͬ���ػ�ҳ��)
		new Thread(this).start();
		
	}
	
	//��дJPanel���е�paint����
	//paint����ר���������ƽ���ģ�ԭ��JFrame���Լ�����ã�
	public void paint(Graphics g){
		//�ѱ���ͼƬ����ͼƬ��������
		g.drawImage(bgImg,0,0,this.getWidth(),this.getHeight(),null);
		g.drawImage(fishImg,fishX,200,fishImg.getWidth(),fishImg.getHeight(),null);
		
		//�ѷ����Ǹ����ָ�����ȥ
		//���ú������ַ�������ɫ
		g.setColor(Color.WHITE);//r(red)g(green)b(blue)
		//���ô�С
		g.setFont(new Font("����",Font.BOLD,30));
		g.drawString("������"+score,30,50);
		
	}
	
	//��дRunnable�е�run����
	public void run()
	{
		//��Ҫ���ǲ��ϵĵ������x����
		while(true){
			fishX-=2;//ÿ�μ���2������
			
			//�����ƶ��Ĺ����У��л�ͼƬ�������ζ���
			fishImg= allFishImgs[currFishIndex++%allFishImgs.length];
			
			//�������x���꣨���ٴδ���Ļ���ұ߳�����
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
