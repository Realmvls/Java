package com.yunsitech;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {		
		//e.getSource();//��ȡ�¼�Դ��ʵ����JButton����
		String command = e.getActionCommand();//���ǰ�ť������ı�
		if("��ť".equals(command)){
			System.out.println("��ť������ˡ�����");
		}
		else if("��ť2".equals(command)){
			System.out.println("��ť2������ˡ�����");
		}
	}
}
