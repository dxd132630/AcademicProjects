public class foobar{
	public static void main(String args[]){
		boolean flag = true;
		for(int i=0;i<50;i++){
			if(i%3==0){
				System.out.print("foo");
				flag = false;
			}
			if(i%5==0){
				System.out.print("bar");
				flag=false;
			}
			if(flag)
				System.out.print(i);
			flag=true;
			System.out.println("\n");
		}
	}
}
