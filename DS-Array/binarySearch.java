import java.util.*;

public class binarySearch{
	/*
	* This functions searches for the key element in the aray
	* @param key the search key
	* @param array elements 
	* @return the position of the key element
	*/
	public static int search(int key, int[] input){
		int low = 0;
		int high = input.length -1 ;
		while( low <= high){
			int mid = low + (high - low) /2;
			if(key < input[mid]) high = mid -1;
			else if (key > input[mid] ) low = mid + 1;
			else return mid;
		}
		return -1;
	}
	public static void main(String[] args){
		int[] input = {1,3,5,8,10,13};
		int pos = search(3,input);
		System.out.println("The position is "+pos);
	}
}
