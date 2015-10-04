import java.util.*;

public class insertionSort{
	public static void main(String[] args){
		int[] in = {1,2,5,3,9,6,2};
		sort(in);
		print(in);
	}
	public static void sort(int[] in){
		int key = 0;
		for(int j=1;j<in.length;j++){
			key = in[j];
			int i=j-1;
			while(i>-1 && in[i]>key){
				in[i+1] = in[i];
				i--;
			}
			in[i+1]=key;
		}
	}
	public static void print(int[] in){
		for(int i=0;i<in.length;i++){
			System.out.print(in[i]+" ");
		}
		System.out.println();
	}
}
