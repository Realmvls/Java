


public class test6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "中国人";
		int len = str1.length();
		System.out.println("["+str1+"]中字符串有:"+ len);
		
		char firstCh = str1.charAt(0);
		char lastCh = str1.charAt(str1.length()-1);
		System.out.println("["+str1+"]第一个字符是："+firstCh);
		System.out.println("["+str1+"]最后一个字符是："+lastCh);
		String strx = "移动流量数据";
		
		String str = "啦啦啦";
		String idx;
		String str2 = "abc";
//		idx = str.lastIndex0f(str2);
		
//		String str = "发送者#接受者#消息正文#时间";
		String[] datas = str.split("#");
		for(String ele : datas){
			System.out.println(ele);
		}
			
	}
}


class Worker{
	String name;
	int age;
	int soc;
	Worker(String name, int age){
		this.name = name;
		this.age = age;
	}
	Worker(int age,String name,int soc){
		this.age = age;
		this.name = name;
		this.soc = soc;
	}
	 String getName(){return name;}
	 void setName(){String name;}{this.name = name;}
	 int getAge(){return age;}
	 void setAge(int age){this.age = age;}
	
	
}