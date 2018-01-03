package com.yunsitech.homework;

import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		Student s1 = new Student("aaa",10,88);
		Student s2 = new Student("bbb",11,58);
		Student s3 = new Student("ccc",11,66);
		Student s4 = new Student("ddd",9,78);
		
		Set<Student> s = new TreeSet<Student>();//就要在Student类中编写排序规则
		s.add(s1);s.add(s2);s.add(s3);s.add(s4);
		
		for(Student stu : s){
			System.out.println(stu.getName()+" "+stu.getAge()+" "+stu.getYwScore());
		}
		
	}
}
