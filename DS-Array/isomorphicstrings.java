import java.util.*; 

public class isomorphicstrings{
	public static boolean checkIsomorphism(String source , String destination){
		if(source == null || destination == null)
			return false;
		if(source.length() == 0 || destination.length() == 0)
			return false;
		HashMap<Character,Character> map = new HashMap<Character,Character> ();
		for(int i=0;i<source.length();i++){
			char c1 = source.charAt(i);
			char c2 = destination.charAt(i);

			Character c = getKey(map,c2);
			if(c!=null && c!=c1)
				return false;
			else if(map.containsKey(c1)){
				if(c2 !=map.get(c1))
					return false;	
			}
			else
				map.put(c1,c2);
	
		}	
		return true;		

	}
	public static Character getKey(HashMap<Character,Character> map,Character target){
		for(Map.Entry<Character,Character> entry : map.entrySet()){
			if(entry.getValue().equals(target)){
				return entry.getKey();
			}
		}
		return null;
	}
	public static void main(String[] args){
		String source = "odd";
		String destination = "egg";
		System.out.println(source+" and "+destination+" isomprphic :"+checkIsomorphism(source,destination));
		source = "egg";
                destination = "saw";
                System.out.println(source+" and "+destination+" isomprphic :"+checkIsomorphism(source,destination));

	}
}
