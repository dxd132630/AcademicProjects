import java.util.*;

public class BipartiteGraph{
	public static void main(String[] args){
		int[][] Graph = {
			{0,0,0,0,0,0,0,0,0},
               		{0,0,1,0,1,0,1,0,0},
                	{0,1,0,1,0,1,0,0,0},
                	{0,0,1,0,1,0,0,0,0},
	                {0,1,0,1,0,1,0,0,0},
        	        {0,0,1,0,1,0,1,0,0},
	                {0,1,0,0,0,1,0,1,0},
                        {0,0,0,0,0,0,1,0,1},
         	        {0,0,0,0,0,0,0,1,0},
            	};
		int[] color = new int[Graph.length];
		color[1] = 1;
		boolean[] checked = new boolean[Graph[0].length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		boolean check = true;
		while(!q.isEmpty()){
			int node = q.poll();
			for(int i=node+1;i<Graph[0].length;i++){
				if(Graph[node][i] == 1){
					if(!checked[node] ) {
						checked[node] = true;
						q.add(i);
					}
					if(color[node] == color[i]){
						check = false;
						break;
					}
					color[i] = -color[node];
				}
			}
			if(!check) break;
		}
		System.out.println(Arrays.toString(color));
            if(check) System.out.println("Given graph is bipartite!");
            else System.out.println("Given graph is NOT bipartite!");
	}
}
