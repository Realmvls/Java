package app1;

import javax.swing.JLabel;

public class Counter extends Thread{
	private JLabel countLbl;//Ҫ���µı�ǩ
	public Counter(JLabel countLbl){
		this.countLbl = countLbl;
	}
	public void run(){
		int num = 1;
		while(true){
			countLbl.setText(""+num);
			num++;
			//���1����
			try {Thread.sleep(1000);} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
