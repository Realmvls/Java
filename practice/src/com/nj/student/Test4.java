package com.nj.student;

class E{
	void doSth(){}
}

//继承的访问修饰符只能比父类更加宽松
//最严格                					最宽松
//private  default  protected  public
class F extends E{
	private void doSth(){}
	private void doSth2(){}
}
public class Test4 {

}
