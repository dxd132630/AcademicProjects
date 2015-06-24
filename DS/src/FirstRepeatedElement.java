import java.util.HashMap;

public class FirstRepeatedElement {
	public static void main(String[] args){
	int[] input = {3,2,1,2,2,3};
	
	fre(input);
	}
	public static void fre(int[] input){
		HashMap<Integer,Integer> inHash = new HashMap<Integer,Integer>();
		for(int i=0;i<input.length;i++){
			if(inHash.containsKey(input[i])){
				int temp = inHash.get(input[i]);
				if(inHash.containsValue(temp)){
					inHash.remove(input[i]);
				inHash.put(input[i],-temp);
				}
			}
			else{
				inHash.put(input[i],(i+1));
			}
			
		}
		System.out.println("First element is repeated");
	}

}

