public class wordConcat{
	public static void wordConcat1(String[] words){
		String sent = "";
		int count =0;
		for(String w : words){
			sent = sent + w;
			count ++;		
		}	
		System.out.println("number of iterations is = "+count);
	}
	public static void wordConcat2(String[] words){
		StringBuffer sent = new StringBuffer();
		int count =0 ;
		for(String w : words){
			sent.append(w);
			count++;
		}
		System.out.println("number of iterations is = "+count);
	}
	public static void main(String[] args){
		String[] words = {"thi", "is", "collection", "of", "words"};
		wordConcat1(words);
		wordConcat2(words);
	}
}
