public class findMaxOfArrayInIncDeArray{
	public static void niveFindmax(int[] input){
		int max_value =0;	
		for(int i=0;i<input.length;i++){
			if(max_value < input[i])
				max_value = input[i];
			else
				break;
		}
		System.out.println("Max value ="+max_value);
	}
	public static void binSearchFindMax(int[] input,int low,int high){
		if(low<=high){
			int mid = low +(high-low)/2;
			if(input[mid]>input[mid+1])
				binSearchFindMax(input,mid,high)
			else
				binSearchFindMax(input,low,mid-1);
		}
		System.out.println("The max value so far is "+input[low]);
	}
	public static void main(String args[]){
		int[] input = {1,5,6,9,15,12,2,-1};
		niveFindmax(input);
	}
}
