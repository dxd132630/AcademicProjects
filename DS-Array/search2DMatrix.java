public class search2DMatrix{
	public static int[] findEleIn2DMatrix(int[][] input,int target){
		int[] result = new int[2];
		result[0] = 999;
		result[1] = 999;
		int m = input.length;
		int n = input[0].length;
		int start =0;
		int end = m*n;
		
		while(start < end){
			int mid = start + (end - start)/2;
			int midX = mid/n;
			int midY = mid%n;
			
			if(input[midX][midY] == target ){
				result[0] = midX;
				result[1] = midY;
				return result;
			}
			else if ( input[midX][midY] < target){
				start = mid + 1;
			}
			else
				end = mid - 1;
		}
		
		return result;
	}
	public static void main(String[] args){
		int[][] input = {{1,3,5,6},
				 {10,11,16,20},
				 {23,30,34,50}};
		int[] pos = findEleIn2DMatrix(input,50);
		if(pos[0] != 999 && pos[1] != 999)
			System.out.println("the result for 50 :"+ pos[0] +" "+pos[1]);
		else
			System.out.println("Element not present!");
		pos = findEleIn2DMatrix(input,1);
		if(pos[0] != 999 && pos[1] != 999)
                	System.out.println("the result for 1 :"+ pos[0] +" "+pos[1]);
		else
			System.out.println("Element not present!");
		pos = findEleIn2DMatrix(input,16);
		if(pos[0] != 999 && pos[1] != 999)
                	System.out.println("the result for 16:"+ pos[0] +" "+pos[1]);
		else
			System.out.println("Element not present!");
		pos = findEleIn2DMatrix(input,36);
		if(pos[0]!=999 && pos[1] != 999)
                	System.out.println("the result 36 :"+ pos[0] +" "+pos[1]);
		else
			System.out.println("Element not present!");
	}
}
