public class FindFrequenciesDistributionOfNum{
	public static void findfreq(int[] input){
		for(int i=0;i<input.length;i++){
			input[i] = input[i]-1;
		}
		for(int i=0;i<input.length;i++){
			input[input[i]%input.length] = input[input[i]%input.length] + input.length;
		}
		for(int i=0;i<input.length;i++){
			System.out.println((i+1)+"->"+input[i]/input.length);
		}
	}
	public static void main(String[] args){
		int[] input = {2,3,3,2,5};
		findfreq(input);
	}
}
