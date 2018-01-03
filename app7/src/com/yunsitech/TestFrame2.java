package com.yunsitech;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestFrame2 extends JFrame implements ActionListener {

	
	private JButton btn;
	private JButton btn2;
	private JTextArea area;//�ı���
	
	public TestFrame2(int width,int height){
//		f = new JFrame("��ʾJFrame");
		this.setTitle("��ʾJFrame");
		this.setSize(width,height);
		//���찴ť
		btn = new JButton("��ť");
		btn2 = new JButton("��ť2");
		//ע���¼�
		btn.addActionListener(this);
		btn2.addActionListener(this);
		
		
		//��Ӱ�ť��JPanel�У�JpanelĬ����FlowLayout���ֹ�������
		JPanel panel = new JPanel();
		panel.add(btn);
		panel.add(btn2);
		
		//��֯һ���ı���		
		area = new JTextArea();
		//ΪJTextArea��ӹ�����
		JScrollPane jsp = new JScrollPane(area);
		
		
		//�ٰ�panel����f�е��ϱߣ�ҳ�����棩
		this.getContentPane().add(panel,BorderLayout.SOUTH);
		this.getContentPane().add(jsp,BorderLayout.CENTER);
		
		//�������
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//��дActionListener�еĳ��󷽷�
	public void actionPerformed(ActionEvent ae){
		Object source = ae.getSource();
		if(source==btn){
			System.out.println("��ť1������ˡ�����");
			area.append("��ť1������ˡ�����\n");
		}
		else if(source==btn2){
			System.out.println("��ť2������ˡ�����");
			area.append("��ť2������ˡ�����\n");
		}
	}
	
	public static void main(String[] args) {
		TestFrame2 tf = new TestFrame2(500,300);
		
	}
}
