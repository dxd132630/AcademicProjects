import java.util.*;

public class Bipartite{
	public boolean isBipartite(int[][] G,int src){
		int[] colorArr = new int[G.length];
		for(int i=0;i<G.length;i++)
			colorArr[i] = -1;
		LinkedList<Integer> que = new LinkedList<Integer>();
		que.add(src);
		while(!que.isEmpty()){
			int u = que.poll();
			for(int v=0;v<G.length;v++){
				if(G[u][v] == 1 && colorArr[v] == -1){
					colorArr[v] = 1-colorArr[u];
					que.add(v);
				}
				else if( G[u][v] == 1 && colorArr[u] == colorArr[v])
					return false;
					
			}
		}
		return true;
	}
	public static void main (String[] args)
   	 {
        	int G[][] = {{0, 1, 0, 1},
            	{1, 0, 1, 0},
            	{0, 1, 0, 1},
            	{1, 0, 1, 0}
        	};
        	Bipartite b = new Bipartite();
        	if (b.isBipartite(G, 0))
           	System.out.println("Yes");
        	else
           	System.out.println("No");
    	}
}
