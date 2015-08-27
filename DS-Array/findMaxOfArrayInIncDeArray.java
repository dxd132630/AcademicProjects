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
	public static void dinSearchFindMax(int[] input,int low,int high){
		if(low<=high){
			int mid = low +(high-low)/2;
			
		}
	}
	public static void main(String args[]){
		int[] input = {1,5,6,9,15,12,2,-1};
		niveFindmax(input);
	}
}
