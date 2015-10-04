class Node{
	int val;
	Node next;
	Node(int val){
		this.val = val;
		this.next = null;
	}
	
}
class Stack{
	Node top;
	
	public Node peek(){
		if(top!=null)
			return top;
		else
			return null;				
	}
	public void push(Node n){
		if(n!==null){
			n.next = n;
			top = n;
		}
	}
	public Node pop(){
		if(top==null)
			return null;
		else{
			Node temp = new Node(top.val);
			top = top.next;
			retun temp;
		}
	}
}
