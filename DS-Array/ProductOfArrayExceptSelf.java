// Author : Deepti Deshpande
// File name: ProductOfArrayExceptSelf.java
// Description : Computes the product of all elements except self in the given array in O(n)

public class ProductOfArrayExceptSelf {
	public static int[] product(int[] nums) {
	    int[] result = new int[nums.length];
	    
	    int[] t1 = new int[nums.length];
	    int[] t2 = new int[nums.length];
	 
	    t1[0]=1;
	    t2[nums.length-1]=1;
	    
	    for(int i=0; i<nums.length-1; i++){
	        t1[i+1] = nums[i] * t1[i];
	    }
	    //prints(t1);
	    //System.out.println();
	 
	    for(int i=nums.length-1; i>0; i--){
	        t2[i-1] = t2[i] * nums[i];
	    }
	    //prints(t2);
	    //System.out.println();
	    for(int i=0; i<nums.length; i++){
	        result[i] = t1[i] * t2[i];
	    }
	    prints(result);
	    System.out.println();
	    return result;
	}
	public static void prints(int[] n){
		for(int i: n){
			System.out.print(i+" ");
		}
	}
	public static void main(String ags[]){
		int[] in = new int[]{4,6,7,8,5};
		int[] result = product(in);
	}

}

