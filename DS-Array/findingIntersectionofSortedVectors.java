import java.util.*;

public class findingIntersectionofSortedVectors{
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7,8};
		int[] b = {4,5,6,7,8,9,10,11,12};

		findIntersection(a,b);
	}
	public static void print(List<Integer> in){
		for(Integer i : in){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void findIntersection(int[] a,int[] b){
		List<Integer> res = new LinkedList<Integer>();
		int i=0;
		int j=0;
		int n1=a.length;
		int n2= b.length;

		while(i<n1 && j<n2){
			if(a[i]<b[j]) i++;
			else if(a[i]>b[j]) j++;
			else{
				res.add(a[i]);
				i++;
				j++;
			}
		}
		print(res);
	}
}
