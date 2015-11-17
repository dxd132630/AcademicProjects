import java.util.*;

public class MatchParenthesis{
	public static void main(String[] a){
		String input ="{a+b{{a}*c}}";
		boolean res = findPar(input);
		if(res == true)
			System.out.println("Match!");
		else
			System.out.println("No Match!");
	}
	public static boolean findPar(String input){
		Stack<Character> s = new Stack<Character>();
		char[] c = input.toCharArray();
		for(int i=0;i<c.length;i++){
			if(c[i] == '{')
				s.push(c[i]);
			else if(c[i] == '}')
				if(s.empty())
					return false;
				else
					s.pop();
		}
		if(!s.empty())
			return false;
		else
			return true;
	}
}
