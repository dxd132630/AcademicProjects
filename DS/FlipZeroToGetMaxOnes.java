/*
*Flip min 2 zeros to get maximum number of one's
*/
import java.util.*;
public class FlipZeroToGetMaxOnes{
	public static void main(String[] args){
		int[] input = { 1,0,1,1,1,0,0,1,1,1,1,};
		System.out.println(Arrays.toString(input));
		int m=2;
		flipZeros(input,m);
	}
	public static void flipZeros(int[] input,int m){
		int n = input.length;
		int WL=0;
		int WR=0;
		int Zero=0;
		int left = 0;
		int bestWindow = 0;
		while(WR<n){
			if(Zero<=m){
				if(input[WR]==0){
					Zero++;
				}
					WR++;
			}
			if(Zero>m){
				if(input[WL]==0){
					Zero--;
				}
				WL++;
			}
			if((WR-WL)>bestWindow){
				bestWindow = (WR-WL);
				left = WL;
			}
			
		}
		for(int i=0;i<bestWindow;i++)
			if(input[left+i] == 0)
				System.out.print(left+i);
	}
}
