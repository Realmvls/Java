package com.nj.student;
import java.util.ArrayList;
import java.util.List;

//ctrl+shift+o  自动补全代码中引用的包模块等，非常好用！


public class Test9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List t = new ArrayList();
		t.add(1);t.add(2);t.add(3);
		System.out.println(t);
		t.set(0,100);
		t.set(t.size()-1, 300);
		System.out.println(t);
		
	}

}
