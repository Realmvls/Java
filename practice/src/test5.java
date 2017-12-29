	
public class test5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int flag;
		int count = 0;
		for(int i=200;i<300;i++){
			
			flag = 0;
			for(int j=2;j<Math.sqrt(i);j++){
				if(i%j==0)
				{
					flag ++;
					
				}
			}
			if (flag==0){
				count ++;
				System.out.print(i+"\t");
				if(count%5==0)
				{
					System.out.print("\n");
				}
			}
		}
		}
	}



