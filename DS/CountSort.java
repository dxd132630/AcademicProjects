import java.util.*;
public class CountSort{
	public static void main(String[] a){
		int[] input = {2,3,1,1,5,6,8};
		countSort(input,1,8);
	}
	public static void countSort(int[] input, int min,int max){
		System.out.println("Input : "+Arrays.toString(input));
		int[] count = new int[max-min+1];
		for(int c: input){
			count[c-min]++;
		}
		int iter = 0;
		for(int i=min;i<max;i++){
			while(count[i-min]>0){
				input[iter] = i;
				iter++;
				count[i-min]--;
			}
		}
		System.out.println("Output : "+Arrays.toString(input));
	}
}
