package com.nj.student;

class Animal{
	String name;
	Animal(){System.out.println("Animal()...");}
	Animal(String nme){System.out.println("Animal(String)...");}
	void eat(){System.out.println("Animal"+name+"eat()...");}
}
class Cat extends Animal{
	Cat(){
		super("aaa");
		System.out.println("Cat()....");
	}
}
public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat c = new Cat();
	}

}
