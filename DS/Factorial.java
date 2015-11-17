public class Factorial{
	public static void main(String[] a){
		int i =iterative_factorial(5);
		int r =recurssive_factorial(5);
		System.out.println("Iterative = "+i+" Recurssive = "+r);
	}
	public static int iterative_factorial(int n){
		if(n<=0)
			return 0;
		int f = 1;
		for(int i=1;i<=n;i++)
			f = f*i;
		return f;
	}
	public static int recurssive_factorial(int n){
		if( n<0)
			return 0;
		if(n==1)
			return 1;
		else
			return n*recurssive_factorial(n-1);
	}
}
