package com.nj.student;

//�˶�Ա
interface Player{
	public abstract void play();
}
//����
interface Drawer{
	
}

class PupileStudent implements Player,Drawer{
	public void play(){System.out.println("play....");}
	public void draw(){System.out.println("draw....");}
	
}


public class Test6 {
	public static void main(String[] args){
		
	}
		
}
