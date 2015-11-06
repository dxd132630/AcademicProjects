public class findMaxAvgSubArray{
	public static int findAvg(int[] input,int k){
		int[] csum = new int[input.length];
		csum[0] = input[0];
		for(int i=1;i<input.length;i++){
			csum[i] = csum[i-1]+input[i];
		}	
		int csum_max = csum[k-1];
		int max_index = k-1;
		for(int i=k;i<input.length;i++){
			int csum_temp = csum[i]-csum[i-k];
			if(csum_max<csum_temp){
				csum_max = csum_temp;
				max_index = i;
			}
		}
		System.out.println("Max avg :"+csum_max/k);
		return max_index;
	}
	public static void main(String[] args){
		int[] input = {1, 12, -5, -6, 50, 3};
		int k = 4;
		int pos = findAvg(input,k);
		System.out.println(pos);
	}
}
