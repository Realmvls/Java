


public class test6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "�й���";
		int len = str1.length();
		System.out.println("["+str1+"]���ַ�����:"+ len);
		
		char firstCh = str1.charAt(0);
		char lastCh = str1.charAt(str1.length()-1);
		System.out.println("["+str1+"]��һ���ַ��ǣ�"+firstCh);
		System.out.println("["+str1+"]���һ���ַ��ǣ�"+lastCh);
		String strx = "�ƶ���������";
		
		String str = "������";
		String idx;
		String str2 = "abc";
//		idx = str.lastIndex0f(str2);
		
//		String str = "������#������#��Ϣ����#ʱ��";
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