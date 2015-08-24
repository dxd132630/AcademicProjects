public class StrtoInt{
	public static int atoi(String str){
		int i=0;
		if(str.length() <1 || str ==null){
			return 0;		
		}	
		char flag = '+';
		if(str.charAt(0) =='-')
			flag = '-';
		i++;
		double result =0;
		while(i< str.length() && str.charAt(i) >= '0' && str.charAt(i) <='9'){
			result = result *10 + (Character.getNumericValue(str.charAt(i)));
			i++;
		}
		if(flag =='-')
		result = -result;
		return (int) result;
	}
	public static void main(String args[]){
	
	String in = "-1234";
	int out = atoi(in);
	System.out.println("out is = "+ out);
	}
}
