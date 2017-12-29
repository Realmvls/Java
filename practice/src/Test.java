
class Person{
	String name;
}
class Student extends Person{
	
}
class Worker{
	String name;
}
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student();
		s.name = "xxx";
		Worker w = new Worker();
		w.name = "zzz";
}

}
