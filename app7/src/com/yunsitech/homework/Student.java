package com.yunsitech.homework;

public class Student implements Comparable<Student>{
	String name;
	int age;
	double ywScore;//语文分数
	
	
	public Student(String name, int age, double ywScore) {
		super();
		this.name = name;
		this.age = age;
		this.ywScore = ywScore;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getYwScore() {
		return ywScore;
	}
	public void setYwScore(double ywScore) {
		this.ywScore = ywScore;
	}
	@Override
	public int compareTo(Student o) {
		if(o!=null){
			int age = o.getAge();
			if(this.age<age){
				return 1;
			}
			else if(this.age>age){
				return -1;
			}
			else{
				//年纪相同
				double score = o.getYwScore();
				if(this.ywScore<score){
					return -1;
				}
				else if(this.ywScore>score){
					return 1;
				}				
			}
		}
		return 0;
	}
	
	
	
}
