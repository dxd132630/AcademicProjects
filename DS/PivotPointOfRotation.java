import java.util.*;
public class PivotPointOfRotation{
	public static int findPivotPoint(int[] input,int low,int high){
		if(input.length==0 || input == null)
			return 999;
		else{
			int mid = low + (high -low)/2;
			if (mid < high && input[mid+1] < input[mid])
           			 return mid+1;
 
        		if (mid > low && input[mid] < input[mid - 1])
            			return mid;
 
        		if (input[high-1] > input[mid])
            			return findPivotPoint(input, low, mid-1);
        		return findPivotPoint(input, mid+1, high);
		}
		
	}
	public static void main(String[] args){
		int[] input = {1, 2, 3, 4};
		int pos = findPivotPoint(input,0,input.length);
		System.out.println("The position of pivot point is :"+pos);
	}
}
