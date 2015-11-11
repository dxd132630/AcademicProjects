import java.util.*;

public class FindSortedRotatedArray{
	public static int findStart(int[] input,int low,int high){
		int mid = low + (high-low)/2;
		if(mid<high && input[mid+1]<input[mid])
			return mid+1;
		if(low<mid && input[mid]<input[mid-1])
			return mid;
		if(input[high] > input[mid]) return findStart(input,low,mid-1);
		return findStart(input,mid+1,high);
	}
	public static void main(String[] args){
		int[] input = {5, 6, 1, 2, 3, 4};
		int pos = findStart(input,0,input.length-1);
		System.out.println("The position of start is :"+pos);
	}
}
