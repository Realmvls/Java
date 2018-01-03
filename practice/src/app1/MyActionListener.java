package app1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if("°´Å¥".equals(command)){
			System.out.println("°´Å¥±»µã»÷ÁË¹þ¹þ¹þ¹þ¹þ");}
		else if("°´Å¥2".equals(command)){
			System.out.println("°´Å¥2±»µã»÷ÁË¹þ¹þ¹þ");}
		else if("°´Å¥3".equals(command)){
			System.out.println("°´Å¥3±»µã»÷ÁË¹þ¹þ¹þ");}
		else if("°´Å¥4".equals(command)){
			System.out.println("°´Å¥4±»µã»÷ÁË¹þ¹þ¹þ");}
		else if("°´Å¥5".equals(command)){
			System.out.println("°´Å¥5±»µã»÷ÁË¹þ¹þ¹þ");}

		}
	}


