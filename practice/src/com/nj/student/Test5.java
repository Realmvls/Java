package com.nj.student;
//����
class Vehicle{
	void run(){
		System.out.println("Vehicle����ʻ");
	}
}
//�γ�
class Car extends Vehicle{
	int a;
	void run(){
		System.out.println("Car����ʻ");
	}
	void doSth(){
		System.out.println("Car dosth����������a = "+a);
	}
}
//
class SUV extends Vehicle{
	void run(){
		System.out.println("SUV run ....");
	}
}
//Bus
class Bus extends Vehicle{}


public class Test5 {
	public static void main(String[] args){
		Vehicle v = new Vehicle();
		v.run();
		Car c = new Car();
		c.run();
//		����������������ʹ��
		v = c;
		v.run();
		
//		v.a = 3;
//		v.doSth();

		Car cc = (Car)v;
		cc.a = 10;
		cc.doSth();
	}
}