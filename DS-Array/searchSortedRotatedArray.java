//Author : Deepti Deshpande
//File name : searchSortedRotatedArray.java
//Description : Search for the element in O(log n) from a sorted rotated array

import java.util.*;

public class searchSortedRotatedArray{

	public static int find(int[] input,int key){
		int result = -1;
		int L = 0;
		int R = input.length-1;

		while ( L<=R){
			int M = L + (R-L)/2;
			if(input[M] == key) result = M;
			if(input[L] <= input[R]){	
				if(input[L] <= key && key <input[M])
					R = M-1;
				else
					L = M + 1;
			}else{
				if(input[M]<key && key<=input[R])
					L= M +1;
				else
					R = M-1;
			}
		}
		return result;
	}
	public static void main(String[] args){
		int[] input = 	{4,5,6,7,0,1,2};	
		int result = find(input,4);
		if(result == -1){
			System.out.println("Value not found !");
		}
		else
			System.out.println("Value is found at position :"+result);
	}
}
