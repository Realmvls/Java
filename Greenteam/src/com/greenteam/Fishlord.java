package com.greenteam;

import javax.swing.JFrame;

import com.greenteam.Pool;

public class Fishlord 
{

	public static void main(String[] args) throws Exception 
	{
		JFrame frame = new JFrame("�������");
		Pool pool = new Pool();
		frame.add(pool);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �رմ���ʱ�رճ���
		frame.setSize(800, 480);
		frame.setLocationRelativeTo(null);// ���ô��ھ��У��������setSize֮��
		frame.setResizable(false);// �������û��ı䴰�ڴ�С
		frame.setVisible(true);//�ɼ�
		pool.action();
	}
}
