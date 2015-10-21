class GraphNode{
	int val;
	GraphNode next;
	GraphNode[] neighbors;
	
	GraphNode(int x){
		val = x ;
	}
	GraphNode(int x, GraphNode[] n){
		val = x;
		neighbors = n;
	}

}
