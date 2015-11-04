import java.util.*;

public class ReverseBits{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input to reverse the bits");
		int input = sc.nextInt();
		System.out.println("Sample input "+input);
		revBit(input);
	}
	public static void revBit(int input){
		int result=0; 
		while(input!=0){
			result <<=1;
			result |=(input & 1);
			input >>=1;
		}
		System.out.println("Sample output "+result);
	}
}
