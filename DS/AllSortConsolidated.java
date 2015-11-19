import java.util.*;

public class AllSortConsolidated{
        public static int[] result;
        public static void main(String[] a){
                int[] input = {1,5,2,5,3,0};
                insertionSort(input);
                int[] input1 = {1,5,2,5,3,0};
                countSort(input1,0,5);
                int[] input2 = {1,3,2,5,3,3,4};
                result = new int[input2.length];
                merge(input2,0,input2.length-1);
                System.out.println(Arrays.toString(result));
		int[] bubble_input = {1,5,2,5,3,0};
		bubbleSort(bubble_input);
        }
        public static void insertionSort(int[] input){
                int key = 0;
                for(int j=1;j<input.length;j++){
                        key = input[j];
                        int i = j-1;
                        while(i>-1 && input[i] > key){
                                input[i+1] = input[i];
                                i--;
                        }
                        input[i+1] = key;
                }
                System.out.println(Arrays.toString(input));
        }
        public static void countSort(int[] input,int min,int max){
                int[] count = new int[max-min+1];
                for(int c: input){      count[c-min]++; }
                int iter= 0;
                for(int i=min;i<=max;i++){
                        while(count[i]>0){
                                input[iter] = i;
                                iter++;
                                count[i]--;
                        }
                }
                System.out.println(Arrays.toString(input));
        }
        public static void merge(int[] input2,int l,int h){
                if(l==h){
                        return;
                }
                else{
                        int mid = (h-l)/2+l;
                        merge(input2,l,mid);
                        merge(input2,mid+1,h);
                        mergeSort(input2,l,mid+1,h);
                }
        }
        public static void mergeSort(int[] input2,int low,int mid,int high){
                int index = 0;
                int i = low;
                int j = mid ;
                while(i<=mid -1 && j<=high){
                        if(input2[i]<input2[j]){
                                result[index++] = input2[i++];
                        }
                        else{
                                result[index++] =input2[j++];
                        }
                }
                while(i<=mid-1){
                        result[index++] = input2[i++];
                }
                while(j<=high)
                        result[index++] = input2[j++];
                for(int p=0;p<(high-low+1);p++)
                        input2[low+p] =  result[p];
        }
	public static void bubbleSort(int[] input){
		for(int i=0;i<input.length-1;i++){
			for(int j=1;j<(input.length-i);j++){
				if(input[j-1]>input[j]){
					int temp = input[j-1];
			                input[j-1] = input[j];
                			input[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(input));
	}
}
