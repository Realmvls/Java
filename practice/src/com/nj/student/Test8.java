package com.nj.student;

import java.util.ArrayList;
import java.util.List;

public class Test8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List t = new ArrayList();
		for(int i=0;i<10;i++){t.add(i);}
		System.out.println(t);
		for(int i=0;i<3;i++){t.remove(i);}
		System.out.println(t);
		t.clear();
		System.out.println(t);
		

	}

}
 