import java.util.*;

public class MaxRotationSum{
	public static int findSum(int[] input){
		int sum = 0;
		int iter_sum = 0;
		int max_sum = 0;
		for(int i=0;i<input.length;i++) sum+=input[i];
		for(int i=0;i<input.length;i++) iter_sum+=i*input[i];
		max_sum = iter_sum;
		for(int i=1;i<input.length;i++){
			iter_sum = iter_sum+sum -(input.length*input[input.length-i]);
			max_sum = max_sum >iter_sum ? max_sum :iter_sum;
			
		}
		return max_sum;
	}
	public static void main(String[] args){
		int[] input = {1, 20, 2, 10};
		int result = findSum(input);
		System.out.println("the result :"+result);
	}
}
