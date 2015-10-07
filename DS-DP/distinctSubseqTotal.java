public class distinctSubseqTotal{
	public static void main(String[] args){
		String s = "rabbbit";
		String t = "rabbit";
		findSubseq(s,t);
	}
	public static void findSubseq(String s,String t){
		int[][] distinct = new int[s.length()+1][t.length()+1];
		for(int i=0;i<s.length();i++){
			distinct[i][0] = 1;
		}

		for(int i=1;i<s.length();i++){
			for(int j=1;j<t.length();j++){
				if(s.charAt(i-1) == t.charAt(j-1))
					distinct[i][j] += distinct[i-1][j]+distinct[i-1][j-1];
				else
					distinct[i][j] += distinct[i-1][j];
				
			}
		}
		System.out.println("The number of  distinct substrings is:"+distinct[s.length()-1][t.length()-1]);
	}
}
