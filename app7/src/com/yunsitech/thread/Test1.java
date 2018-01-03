package com.yunsitech.thread;
class PrintNumThread extends Thread{
	//��дThread���е�run����
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.print(i+" ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class PrintCharThread implements Runnable{

	@Override
	public void run() {
		for(char c = 'A';c<='Z';c++){
			System.out.print(c+" ");
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
public class Test1 {

	public static void main(String[] args) {
		//ͬ�����루ʹ�õ��̣߳�
		test1();
		System.out.println("\n-------------\n");
		//�첽���루ʹ�ö��̴߳�����Ч����
		test2();
		
	}
	public static void test2(){
		//ִ��test2����������߳�
		//����һ���µ��̣߳�Ȼ���µ��߳��д�ӡ1-10
		PrintNumThread pnt = new PrintNumThread();
		pnt.start();
//		pnt.run();//ͬ����
		//start�������ûᴴ���µ��̣߳�
		//Ȼ�����µ��߳���ִ��pnt��run�����е��߼�
		
		PrintCharThread pct = new PrintCharThread();
		//pct.start();//start()������Thread���ж����
		//����ʱPrintCharThread�������Runnable������
		//������Thread�����࣬��Ȼû��start�������Ե��ã�
		Thread t = new Thread(pct);//Thread(Runnable)
		t.start();
		
		//ִ��test2�������̼߳�����ӡa-z
		for(char c = 'a';c<='z';c++){
			System.out.print(c+" ");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void test1(){
		//��ӡ1-10��֮���ӡa-z
		for(int i=1;i<=10;i++){
			System.out.print(i+" ");
		}
		for(char c = 'a';c<='z';c++){
			System.out.print(c+" ");
		}
		
	}
}
