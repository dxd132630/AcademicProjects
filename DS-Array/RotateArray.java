public class RotateArray{
	public static int[] reverse(int[] in, int left,int right){
		if(left>=right)
			return in;
		while(left<right){
			int temp = in[left];
			in[left]=in[right];
			in[right]=temp;
			left++;
			right--;		
		}
		return in;
	}	
	public static void prints(int[] in){
		for(int i=0;i<in.length;i++){
			System.out.print(in[i])	;	
		}	
		System.out.println();
	}
	public static void main(String args[]){
		
		int[] in = {1,2,3,4,5,6};
		System.out.println("Input array is : ");
		prints(in);
		int a = in.length - 2;
		int[] b = reverse(in,0, a-1);
		in = reverse(b,a,in.length-1);
		b = reverse(in,0,in.length-1);
		System.out.println("Output array is : ");
		prints(b);
		
	}
}
