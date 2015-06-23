import java.util.Arrays;
import java.util.HashMap;

public class DSDuplicateString {
	public static void main(String[] args){
		String input = "1232123";
		dsduplicatestringbruteforce1(input);
		dsduplicatestringbruteforce2(input);
		dsduplicatestringhashing(input);
		dsduplicatestringindexnegation(input);
		
	}
	public static void dsduplicatestringbruteforce1(String input){
		
		for(char a: input.toCharArray()){
			for( char b:input.toCharArray()){
				if(a==b){
					System.out.println("Call 1 : Char "+a+" is repeated");
					break;
				}
			}
			
		}
	}
	public static void dsduplicatestringbruteforce2(String input){
		char[] sortinput = input.toCharArray();
		Arrays.sort(sortinput);
		for(int i=0;i<sortinput.length-1;i++){
			if(sortinput[i]==sortinput[i+1]){
				System.out.println("Call 2 : Char "+sortinput[i]+" is repeated");
				break;
			}
		}
	}
	public static void dsduplicatestringhashing(String input){
		HashMap<String,String> inHash = new HashMap<String,String>();
		for(char a: input.toCharArray()){
			if(inHash.containsKey(String.valueOf(a))){
				System.out.println("Call 3 : Char "+a+" is repeated");
				break;
			}
			else 
				inHash.put(String.valueOf(a),String.valueOf(a));
		}
	}
	public static void dsduplicatestringindexnegation(String input){
		int i=0;
		int[] inarray = new int[input.length()];
		char[] inchar = input.toCharArray();
		for(i=0;i<input.length();i++){
			inarray[i] = Integer.parseInt(String.valueOf(inchar[i]));
		}
		for(i=0;i<input.length();i++){
			
			if(inarray[Math.abs(inarray[i])]<0){
				System.out.println("Call 4 : Char "+Math.abs(inarray[i])+" is repeated");
				break;
			}
			else
				inarray[Math.abs(inarray[i])] = -inarray[Math.abs(inarray[i])];
		}
	}
}
