import java.util.*;
class bucket{
	int low;
	int high;
	bucket(){
		this.low = -1;
		this.high = -1;
	}
}
public class bucketSortToFindMaxGap{
	public static void main(String[] args){
		int[] in = {1,5,6,2,9,34};
		bucketSort(in);
	}
	public static void bucketSort(int[] in){
		int result = 0;
		 if(in == null || in.length < 2){
		        result = 0;
		    }
		 
			int max = in[0];
			int min = in[0];

			for(int i=1;i<in.length;i++){
				max = Math.max(max,in[i]);
				min = Math.min(min,in[i]);
			}

				
			bucket[] buckets = new bucket[in.length+1];
			for(int i=0;i<in.length+1;i++){
				buckets[i] = new bucket();
			}	
			double interval = (double) in.length / (max-min);
		    //distribute every inber to a bucket array
		    for(int i=0; i<in.length; i++){
		        int index = (int) ((in[i] - min) * interval);
		 
		        if(buckets[index].low == -1){
		            buckets[index].low = in[i];
		            buckets[index].high = in[i];
		        }else{
		            buckets[index].low = Math.min(buckets[index].low, in[i]);
		            buckets[index].high = Math.max(buckets[index].high, in[i]);
		        }
		    }
		    int prev = buckets[0].high;
		    for(int i=1; i<buckets.length; i++){
		        if(buckets[i].low != -1){
		            result = Math.max(result, buckets[i].low-prev);
		            prev = buckets[i].high;
		        }
		 
		    }
		 
		    System.out.println("Max gap: "+result);
		}	
}
