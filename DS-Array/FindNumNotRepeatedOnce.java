import java.util.*;

public class FindNumNotRepeatedOnce{
	public static void main(String[] args){
		int[] input = {1,3,1,4,3,2,4,2,5};
		findNonRepeatedNumber(input);
	}
	public static void findNonRepeatedNumber(int[] input){
		int j = 0;
		for(int i=0;i<input.length;i++){
			j = j ^ input[i];
		}
		System.out.println("The non-repeated number is :"+j);
	}
}
