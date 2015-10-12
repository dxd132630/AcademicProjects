import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class a {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int pcount = 0;
        int ncount = 0;
        int zcount = 0;
        int total = 0;
        for(int i=0;i<N ;i++){
            if(s.nextInt() < 0)
                   ncount++;
            else if(s.nextInt()>0)
                   pcount++;
            else
                   zcount++;
            total++;
         }
        System.out.printf("%.3f",((double)pcount/total));
        System.out.printf("%.3f",((double)ncount/total));
        System.out.printf("%.3f",((double)zcount/total));                  
    }
}
