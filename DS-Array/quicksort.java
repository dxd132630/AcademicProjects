import java.util.* ;
public class quicksort{

	public static void main(String args[]){
		int[] inputArray = {1,5,2,10,4,1};
		System.out.println("Input array before sorting is : "+ Arrays.toString(inputArray));
		
		int low = 0;
		int high = inputArray.length -1 ;
		
		quickSort(inputArray, low, high);
		System.out.println("Output array after sorting is : "+ Arrays.toString(inputArray));
	}
	public static void quickSort(int[] inputArray, int low, int high){
		
		if(inputArray == null || inputArray.length == 0)
			return;
		if(low >= high)
			return;
		int middle = low +(high-low) /2;
		int pivot = inputArray[middle];

		int i=low, j=high;
		while(i<=j){
			while(inputArray[i] < pivot){
				i++;
			}
			while(inputArray[j] > pivot){
				j--;
			}
			if(i<=j){
				int temp = inputArray[i];
				inputArray[i] = inputArray[j];
				inputArray[j] = temp;
				i++;
				j--;
			}
		}
		if(low < j)
			quickSort(inputArray,low, j);
		if(high > i)
			quickSort(inputArray,i,high);
	}
}
