import java.util.*;

public class editDistance{
	public static int findEditDistance(String w1, String w2){
		if(w1.length() ==0 || w2.length() == 0){
			if(w1.length() > w2.length())
				return w1.length();
			else
				return w2.length() ;
		}	
		
		int l1 = w1.length();
		int l2 = w2.length();	
		int[][] dp = new int[l1+1][l2+1];

		for(int i=0;i<l1;i++)	{ dp[i][0] = i; }
		for(int j=0;j<l2;j++)	{ dp[0][j] = j; }
		
		for(int i=0;i<l1;i++){
			char c1 = w1.charAt(i);
			for(int j=0;j<l2;j++){
				char c2 = w2.charAt(j);
				if(c1 == c2){
					dp[i+1][j+1] = dp[i][j];
				}
				else{
					int replace = dp[i][j]+1;
					int delete = dp[i+1][j]+1;
					int insert = dp[i][j+1]+1;

					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete ;
					dp[i+1][j+1] = min;
				}
			}
		}
		return dp[l1][l2];
	}
	public static void main(String[] args){
		String w1= "abc";
		String w2 = "ade";
		int distance = findEditDistance(w1,w2);
		System.out.println("the distance between w1:"+w1+" and w2:"+w2+" is ="+distance);
		w2 = "def";
		distance = findEditDistance(w1,w2);
                System.out.println("the distance between w1:"+w1+" and w2:"+w2+" is ="+distance);
		w2="";
		distance = findEditDistance(w1,w2);
                System.out.println("the distance between w1:"+w1+" and w2:"+w2+" is ="+distance);
	}
}
