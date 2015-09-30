import java.util.*;

public class FindSmartString {
	public static String findSmartString(String input, int sLength){
		String result="";
		for(String s : input.split(" ")){
			if(result.length() < sLength){
				if((sLength - result.length()) > s.length()){
					if(result.length() == 0)
						result = s;
					else
						result = result+" "+ s;
				}
				else
					return result;
			}
			else 
				return result;
		}
		return result;	
	}
	public static void main(String args[]){
		String input = "Featuring stylish rooms and moornings for recreation boats, Room Mate Aitana is a designer hotel built in 2013 on an island in the IJ River in Amsterdam.";
		System.out.println("The smart substring of the given string is :\""+findSmartString(input,30)+"\"");

	}
}

