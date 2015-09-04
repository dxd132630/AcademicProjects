import java.util.*;
public class primeNumber{
	public static boolean ifPrime(int number){
		if(number %2 ==0) return false;
		else{
			for(int i=3;i*i<=number;i=i+2){
				if(number % i == 0)
					return false;
			}
			return true;
		}
	}
	public static void printPrimeList(int size){
		boolean[] prime = new boolean[size];
		Arrays.fill(prime,true);
		prime[0]=prime[1]=false;
		for(int i=2;i<size;i++){
			if(prime[i])
				for(int j=2;i*j<size;j++){
					prime[i*j]=false;
				}
		}
		for(int i=0;i<size;i++){
			System.out.println(i+" "+prime[i]);
		}
	}
	public static void main(String[] args){
		System.out.println("11 is Prime :"+ifPrime(11));
		System.out.println("2 is Prime : "+ifPrime(2));
		printPrimeList(10);
	}
}
