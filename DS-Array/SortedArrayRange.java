import java.util.ArrayList;
import java.util.List;


public class SortedArrayRange {
	public static List<String> summaryRanges(int[] nums) {
	    List<String> result = new ArrayList<String>();
	 
	    if(nums == null || nums.length==0)
	        return result;
	 
	    if(nums.length==1){
	        result.add(nums[0]+"");
	    }
	 
	    int pre = nums[0]; // previous element   
	    int first = pre; // first element of each range
	 
	    for(int i=1; i<nums.length; i++){
	            if(nums[i]==pre+1){
	                if(i==nums.length-1){
	                    result.add(first+"->"+nums[i]);
	                }
	            }else{
	                if(first == pre){
	                    result.add(first+"");
	                }else{
	                    result.add(first + "->"+pre);   
	                }
	 
	                if(i==nums.length-1){
	                    result.add(nums[i]+"");
	                }
	 
	                first = nums[i];
	            }
	 
	            pre = nums[i];
	    }
	 
	    return result;
	}
	public static void main(String ags[]){
		int[] in = new int[]{0,1,2,4,5,7};
		List<String> result = summaryRanges(in);
		System.out.println(result.toString());
	}

}
