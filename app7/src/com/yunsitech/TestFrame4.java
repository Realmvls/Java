package com.yunsitech;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TestFrame4 extends JFrame 
	implements ActionListener{

	private JPanel contentPane;
	private JButton countBtn;//��ʼ�����İ�ť
	private JLabel countLbl;//�����ı�ǩ
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame4 frame = new TestFrame4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		countBtn = new JButton("\u8BA1\u6570");
		countBtn.setBounds(181, 208, 93, 23);
		contentPane.add(countBtn);
		
		
		JLabel label = new JLabel("\u8BA1\u6570\uFF1A");
		label.setBounds(87, 60, 54, 15);
		contentPane.add(label);
		
		countLbl = new JLabel("");
		countLbl.setBounds(145, 60, 140, 15);
		contentPane.add(countLbl);
		
		//Ϊ��ť����¼�
		countBtn.addActionListener(this);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//����һ���̣߳�����������߼��������µ��߳���ִ��
		//��ִ��actionPerformed������ִ���ߣ�����
		//�ػ�ҳ�棨JFrame�Լ���������������
		
		new Counter(countLbl).start();//�����µ��߳�
	}
}
