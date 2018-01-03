package com.yunsitech.thread;
class PrintNumThread extends Thread{
	//重写Thread类中的run方法
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
		//同步代码（使用单线程）
		test1();
		System.out.println("\n-------------\n");
		//异步代码（使用多线程带来的效果）
		test2();
		
	}
	public static void test2(){
		//执行test2方法的这个线程
		//创建一个新的线程，然后新的线程中打印1-10
		PrintNumThread pnt = new PrintNumThread();
		pnt.start();
//		pnt.run();//同步的
		//start方法调用会创建新的线程，
		//然后在新的线程中执行pnt的run方法中的逻辑
		
		PrintCharThread pct = new PrintCharThread();
		//pct.start();//start()方法是Thread类中定义的
		//而此时PrintCharThread这个类是Runnable的子类
		//并不是Thread的子类，自然没有start方法可以调用！
		Thread t = new Thread(pct);//Thread(Runnable)
		t.start();
		
		//执行test2方法的线程继续打印a-z
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
		//打印1-10，之后打印a-z
		for(int i=1;i<=10;i++){
			System.out.print(i+" ");
		}
		for(char c = 'a';c<='z';c++){
			System.out.print(c+" ");
		}
		
	}
}
