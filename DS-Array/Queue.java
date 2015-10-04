class Queue{
	Node head,tail;
	public void enqueue(Node n){
		if(head==null){
			head = n;
			tail = head;	
		}
		else{
			tail.next = n;
			tail = n;
		}
	}
	public Node dequeue(){
		if(first == null)
			return null;
		else{
			Node temp = new Node(head.val);
			head = head.next;
			return temp;
		}	
	}
}
