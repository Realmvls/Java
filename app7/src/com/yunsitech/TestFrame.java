package com.yunsitech;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestFrame {

	public static void main(String[] args) {
		JFrame f = new JFrame("��ʾJFrame");
		//���ô����С
		int width = 500;
		int height=380;
		int x = 100;
		int y = 100;
		f.setSize(width,height);
		//f.setBounds(x, y, width, height);
		
		//�����ô�����Ļ������ʾ
		f.setLocationRelativeTo(null);
		
		//����һ����ť
		JButton btn = new JButton("��ť");
		JButton btn2 = new JButton("��ť2");
		
		//Ϊ��ť��ӵ���¼�
		MyActionListener listener = new MyActionListener();
		btn.addActionListener(listener);
		btn2.addActionListener(listener);
		//void addActionListener(ActionListener)
		
		//�Ѱ�ť������"��JFrame����
		//Container c = f.getContentPane();//��ȡJFrame����������
		//c.add(btn,BorderLayout.EAST);//��ͼ��ӵ����������е��м�λ��
		
		//��һ�����ֹ�����
		f.setLayout(new FlowLayout());
		f.getContentPane().add(btn);
		f.getContentPane().add(btn2);
		
		//������ʾ����
		f.setVisible(true);
		//�ô������ϽǵĹرհ�ť����Ч��
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
