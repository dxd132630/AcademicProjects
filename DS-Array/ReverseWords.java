public class ReverseWords{
    public static void main(String args[]){
    String str[] = "string to be reversed".split(" ");
    
    String finalStr="";
        for(int i = str.length-1; i>= 0 ;i--){
            finalStr += str[i]+" ";
        }
        System.out.println(finalStr);
    }
}
