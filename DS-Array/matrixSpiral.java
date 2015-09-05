import java.util.*;

public class matrixSpiral{
	public static void printMatrixSpiral(int[][] matrix){
		ArrayList<Integer> aMatrix = new ArrayList<Integer>();		
		int m = matrix.length;
		int n = matrix[0].length;
		int x=0;
		int y=0;
		while(m>0 && n>0){
			if(m==1){
				for(int i=0;i<n;i++)
					aMatrix.add(matrix[x][y++]);
			break;
			}
			else if(n==1){
				for(int i=0;i<m;i++){
					aMatrix.add(matrix[x++][y]);
				}
			break;
			}
			//top - move right	
			for(int i=0;i<n-1;i++)
				aMatrix.add(matrix[x][y++]);
			//top - move down
			for(int i=0;i<m-1;i++)
				aMatrix.add(matrix[x++][y]);
			//bottom - move left
			for(int i=0;i<n-1;i++)
				aMatrix.add(matrix[x][y--]);
			//bottom - move up
			for(int i=0;i<m-1;i++)
				aMatrix.add(matrix[x--][y]);
			x++;
			y++;
			m-=2;
			n-=2;
		}
		System.out.print(aMatrix.toString());
		System.out.println();
		
	}
	public static void main(String[] args){
		int[][] matrix = {{ 1, 2, 3 },
 				{ 4, 5, 6 },
 				{ 7, 8, 9 }};
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
		printMatrixSpiral(matrix);
	}
}
