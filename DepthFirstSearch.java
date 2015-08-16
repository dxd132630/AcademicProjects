/*
 * 				@ Author 			: Deepti Deshpande
 * 				@ Net ID 			: dxd132630
 * 				@ File Name 		: DepthFirstSearch
 * 				@ Details 			: DFS to check the network connectivity
 */


public class DepthFirstSearch
{
   int[][]  adjMatrix;
   int      NumOfNodes;
   int[] trace = new int[15];
   boolean[] visited; 

   DepthFirstSearch(int[][] stateMatrix)
   {
      int i, j;
     
      NumOfNodes = stateMatrix.length;

      adjMatrix = new int[NumOfNodes][NumOfNodes];
      visited = new boolean[NumOfNodes];


      for ( i=0; i < NumOfNodes; i++) {
         for ( j=0; j < NumOfNodes; j++){
            adjMatrix[i][j] = stateMatrix[i][j];
         }
      }
   }
   public boolean checkConnectivity(){
	   boolean flag = false;
	   for(int i=0;i<NumOfNodes;i++){
	    	  dfs(i);
	    	  int count =0;
	    	  for(int j=0;j<NumOfNodes;j++)
	    		  count+=trace[j];
	    	  if(count==120){
	    		 // System.out.println("UP");
	    		  flag = true;
	    		  break;
	    	  }
	    	  else
	    		  clearVisited();
	      }
	      return flag;
   }

   public int[] dfs(int i)
   {
      int j;

      visited[i] = true;
      trace[i] = i+1;
      for ( j = 0; j < NumOfNodes; j++ )
      {
    	  if ( adjMatrix[i][j] > 0 && !visited[j] )
            dfs(j);
      }
    	  return trace;
      
   }

   public void clearVisited()
   {
      int i;

      for (i = 0; i < visited.length; i++){
         visited[i] = false;
      }
      for(i=0;i<NumOfNodes;i++)
    	  trace[i]=0;
   }

}