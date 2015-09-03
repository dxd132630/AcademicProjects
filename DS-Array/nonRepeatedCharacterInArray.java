import java.util.*;

public class nonRepeatedCharacterInArray{
        public static void findNonepeatedCharacterInArray(String input){
                HashMap<Character, Integer> hashInput = new HashMap<>();
                for(int i=0;i<input.length();i++){
                        char c = input.charAt(i);
                        if(hashInput.containsKey(c)){
                                hashInput.put(c,hashInput.get(c)+1);
                        }
                        else{
                                hashInput.put(c,1);
                        }
                }
                for(int i=0;i<input.length();i++){
                	if(hashInput.get(input.charAt(i))==1){
                		System.out.println("The non-repeated character is :"+input.charAt(i));
                		return;
                	}	
                }
        }
        public static void main(String args[]){
                String input="swiss";
                findNonepeatedCharacterInArray(input);
        }
}
