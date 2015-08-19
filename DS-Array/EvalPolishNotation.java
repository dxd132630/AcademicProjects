//import java.util.stack ;
import java.util.* ;

public class EvalPolishNotation{
	public static void main(String args[]){
		String[] input = {"4", "13", "5", "/", "+"};
		System.out.println(evalPN(input));
	}
	public static int evalPN(String[] input){
		int returnVal = 0;
		Stack<String> st = new Stack<>();
		String operators = "+-*/";
		for(String t: input){
			if(!operators.contains(t))
				st.push(t);
			else{
				int a = Integer.valueOf(st.pop());
				int b = Integer.valueOf(st.pop());
				switch(t){
					case "+"  : st.push(String.valueOf(a+b)); break;				
					case "-"  : st.push(String.valueOf(b-a)); break;			
					case "*"  : st.push(String.valueOf(a*b)); break;	
					case "/"  : st.push(String.valueOf(b/a)); break;					
				}
			}		
		}
			returnVal = Integer.valueOf(st.pop());
			return returnVal;
		
	}
}
