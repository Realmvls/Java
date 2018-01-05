package com.yunsitech.fish03;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;

public class FishFrame extends JFrame{

	private FishPool fishPool = null;
	
	public FishFrame(){
		this(800,600);
	}
	public FishFrame(int width,int height){
		//���ý���ı���
		this.setTitle("����Ӧ��");
		//���ý����Ⱥ͸߶�
		this.setSize(width,height);
		//�ý�����Ļ������ʾ
		this.setLocationRelativeTo(null);
		
		//��ʼ������ӣ�JPanel��
		fishPool = new FishPool();
		
		Container c = this.getContentPane();
		c.add(fishPool,BorderLayout.CENTER);
		
		//�ùرհ�ť���Խ�������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��ʾ����
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		FishFrame f = new FishFrame();
	}
}
