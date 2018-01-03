package com.yunsitech;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {		
		//e.getSource();//获取事件源其实就是JButton对象
		String command = e.getActionCommand();//就是按钮上面的文本
		if("按钮".equals(command)){
			System.out.println("按钮被点击了。。。");
		}
		else if("按钮2".equals(command)){
			System.out.println("按钮2被点击了。。。");
		}
	}
}
