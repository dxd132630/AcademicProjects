import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void genNum(int n,int k){
        int maxk =0;
        int result = 0;
        for(int i=1;i<n;i++){
            int res = i & (i+1);
	    System.out.println("bool ="+res+" "+i+" "+(i+1)+" "+(i&(i+1)));
            res = res < k ? res : maxk;
            System.out.println("res="+res);
            maxk = Math.max(maxk,res);
        }
        System.out.println(maxk);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int[] N = new int[T];
        int[] K = new int[T];
        for(int i=0;i<T;i++){
            N[i] = s.nextInt();
            K[i] = s.nextInt();
        }
        for(int i=0;i<T;i++){
            genNum(N[i],K[i]);
        }
    }
}
