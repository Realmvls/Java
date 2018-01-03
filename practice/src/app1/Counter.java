package app1;

import javax.swing.JLabel;

public class Counter extends Thread{
	private JLabel countLbl;//要更新的标签
	public Counter(JLabel countLbl){
		this.countLbl = countLbl;
	}
	public void run(){
		int num = 1;
		while(true){
			countLbl.setText(""+num);
			num++;
			//间隔1秒钟
			try {Thread.sleep(1000);} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
