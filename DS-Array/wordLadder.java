import java.util.*;

class wLadder{
	String word;
	int length;
	wLadder(String word, int lenght){
		this.word = word;
		this.length = length;
	}
}
public class wordLadder{
	public static void main(String[] args){
		String start ="hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		findMinLenght(start,end,dict);
	}
	public static void findMinLenght(String start,String end, Set<String> dict){
		LinkedList<wLadder> wl = new LinkedList<wLadder>();
		wl.add(new wLadder(start,1));

		dict.add(end);
		
		while(!wl.isEmpty()){
			wLadder top = wl.remove();
			String w = top.word;
			if(w.equals(end))
				System.out.println("the min length is :"+top.length);
			char[] arr = w.toCharArray();
			for(int i=0;i<arr.length;i++){
				for(char a = 'a' ; a<='z';a++){
					char temp = arr[i];
					if(arr[i]!=a){	
						arr[i]=a;
					}
					String nw = new String(arr);
					if(dict.contains(nw)){
						wl.add(new wLadder(nw,top.length+1));
						dict.remove(nw);
					}
					arr[i]=temp;
				}
			}
		}
	}
}
