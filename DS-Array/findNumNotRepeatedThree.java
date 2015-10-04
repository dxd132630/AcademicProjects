public class findNumNotRepeatedThree{
	public static int singleNumber(int[] A) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < A.length; i++) {
			twos |= ones & A[i];
       			ones ^= A[i];
        		threes = ones & twos;
        		ones &= ~threes;
        		twos &= ~threes;
			System.out.println("one="+ones+" thwo="+twos+" threes="+threes);
    		}
    		return ones;
	}
	public static void main(String[] args){
		int[] in = {1,1,1,2,3,3,3,4,4,4};
		System.out.println(singleNumber(in));
	}
}
