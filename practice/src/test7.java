
public class test7 {

	public static void main(String[] args) {
		Worker wor1 = new Worker("jid",123);
		System.out.println(wor1.name+" "+wor1.age);
		Worker wor2 = new Worker(41,"jidsf",95);
		System.out.print(wor2.name+" "+wor2.age+" "+wor2.soc);

	}

}


class Man{
	void sayHello(String name){System.out.println("Man��"+name+"���к�");}
	void sayHello(String name,String name2){System.out.println("Man��"+name+","+name2+"���к�");}
	void sayHello(String... names){
		System.out.print("Man���к�");
		for(int i=0;i<names.length;i++){
			String name = names[i];
			System.out.print(name);
			if (i<names.length-1){
				System.out.print(",");
			}
		}
		System.out.println("���Ǻ�");
	}
}
