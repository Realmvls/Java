package com.yunsitech.fish04;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
public class FishPool 
	extends JPanel 
	implements Runnable,MouseListener,MouseMotionListener{
	
	private BufferedImage bgImg;//����ͼƬ
	private int score;//����ĵ÷�
	
	//һЩ�㣨Fish���͵Ķ���
	private Fish[] fishes;//������

	//����һ�������Զ������ͣ�ͼƬ��ץ��Ķ����ȵȣ�
	private Net net;
	
	public FishPool(){
		//��ʼ����
		net = new Net();
		//��ʼ����
		fishes = new Fish[20];
		for(int i=1;i<=9;i++){
			fishes[i-1] = new Fish("fish0"+i);
			fishes[i+8] = new Fish("fish0"+i);
		}
		fishes[18] = new Fish("fish13");
		fishes[19] = new Fish("fish14");
		
		//��ʼ��ͼƬ(��ȡ�����ϵ�ͼƬ��
		try {
			bgImg = ImageIO.read(new File("imgs/bg.jpg"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//!!!�����������������Fish�ڲ�Ҫ�Լ��ĸı�X�ᣬ�Լ��л�ͼƬ��
		//���������Ϊ�߳�������߼�
		
		//���Լ������̸߳�����
		//(��ͣ�ĸı����x���꣬���ͬʱ��ͬ���ػ�ҳ��)
		new Thread(this).start();
		
	}
	
	//��дJPanel���е�paint����
	//paint����ר���������ƽ���ģ�ԭ��JFrame���Լ�����ã�
	public void paint(Graphics g){
		//��أ�JPanel��ע��MouseListener
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		//�ѱ���ͼƬ����ͼƬ��������
		g.drawImage(bgImg,0,0,this.getWidth(),this.getHeight(),null);
		
		//��ͼ��20�����������
		for(Fish fish : fishes){
			
			g.drawImage(fish.getFishImage(),
					fish.getFishX(),
					fish.getFishY(),
					fish.getFishWidth(),
					fish.getFishHeight(),
					null);
		}
		
		//�Ѳ��������ͼƬ��Ҳ��������
		if(net.isShow()){
			g.drawImage(net.getNetImg(),
					net.getNetX()-net.getNetWidth()/2,
					net.getNetY()-net.getNetHeight()/2,
					net.getNetWidth(),
					net.getNetHeight(),
					null);
		}
		
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
		//1�����е��㶯��������Ϊÿһ�������һ���̣߳�
		for(Fish fish: fishes){
			new Thread(fish).start();
		}
		//2.��ͣ���ػ�ҳ��
		while(true){
			this.repaint();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//�����ʱ�򣬾��ǲ���Ĺ���
	//�鿴�����������ϵ
	@Override
	public void mousePressed(MouseEvent e) {
		for(Fish fish : fishes){
			if(net.catchFish(fish)){
				fish.disappear();
				//�������
				score+=1;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//����ƶ��������ڲ�
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mouseEntered....");
		net.showNet();
	}

	//���ӽ������Ƴ�
	@Override
	public void mouseExited(MouseEvent e) {
//		System.out.println("mouseExited....");
		net.hideNet();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//������ƶ���Ӧ��������ͼƬ����걣��ͬһ����
		//1.����ƶ���ʱ�����������λ�ȡ��
		int mx = e.getX();
		int my = e.getY();
		//2.����ͼƬ��x��y������x��y����ͬ��
		net.move(mx,my);
	}
}
