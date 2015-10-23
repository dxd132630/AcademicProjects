public class RotateMatrixbyRtAngle{
	public static void rotate(int[][] input){
		int temp =0;
		int n=input.length;
		int m=input[0].length;
		for(int i=0;i<(input.length /2);i++){
			for(int j=0;j<Math.ceil(((double) n) / 2);j++){
				temp = input[i][j];
				input[i][j] = input[n-1-j][i];
				input[n-1-j][i] = input[n-1-i][n-1-j];
				input[n-1-i][n-1-j] = input[j][n-1-i];
				input[j][n-1-i] = temp;
			}
		}
		print(input);
	}
	public static void print(int[][] input){
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++){	
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};	
		print(matrix);
		rotate(matrix);
	}
}

