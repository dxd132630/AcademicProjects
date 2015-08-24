public class ReverseWords{
	public static String revStr(String input){
		String out = "";
		char[] temp = input.toCharArray();
		for(int i=temp.length-1;i>=0;i--){
			out += Character.toString(temp[i]); 
		}
		
		return out;
	}
    public static void main(String args[]){
    	String in = "string to be reversed";
	    String str[] = in.split(" ");
	    
	    String finalStr="";
	    System.out.println("in ="+in);
	    finalStr = revStr(in);
	    str = finalStr.split(" ");
	    in = "";
	    for(int i= 0;i<str.length;i++){
	    	in+= revStr(str[i])+ " ";
	    }
	    System.out.println("rev ="+in);
	    
	}
    
}
