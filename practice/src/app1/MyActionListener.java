package app1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if("��ť".equals(command)){
			System.out.println("��ť������˹���������");}
		else if("��ť2".equals(command)){
			System.out.println("��ť2������˹�����");}
		else if("��ť3".equals(command)){
			System.out.println("��ť3������˹�����");}
		else if("��ť4".equals(command)){
			System.out.println("��ť4������˹�����");}
		else if("��ť5".equals(command)){
			System.out.println("��ť5������˹�����");}

		}
	}


