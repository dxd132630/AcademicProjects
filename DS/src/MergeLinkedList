public class MergeLinkedList{
	public static void main( String args[]){
		MergeLinkedList ll = new MergeLinkedList();
		Node l1 = ll.prepLL(new int[]{1,3,8,9});
		Node l2 = ll.prepLL(new int[]{1,2,4,5,8,9});
		Node merged = ll.mergeLL(l1,l2);
		ll.printll(merged);
	}
	Node mergeLL(Node l1,Node l2){
		if( l1.next == null){
			if(l1.data <= l2.data){
				l1.next=l2;
				return l1;
			}else{
				Node head;
				head = l2;
				while(l2.data<l1.data){
					l2 = l2.next;
				}
				Node tmp = l2.next;
				l2.next = l1;
				l1.next = tmp;
				return head;
			}
		}
		if( l2.next == null){
			if(l2.data <= l1.data){
				l2.next=l1;
				return l2;
			}else{
				Node head;
				head = l1;
				while(l1.data<l1.data){
					l1 = l1.next;
				}
				Node tmp = l1.next;
				l1.next = l1;
				l2.next = tmp;
				return head;
			}
		}
		Node head;
		if(l1.data < l2.data)
			head = l1;
		else{
			head = l2;
			l2 = l1;
			l1=head;
		}
		while(l1.next != null && l2 != null){
			if(l1.next.data <= l2.data)
				l1 = l1.next;
			else{
				Node tmp = l1.next;
				l1.next = l2;
				l2 = tmp;
			}
		}
		if(l1.next == null)
			l1.next = l2;
		return head;
	}		
	public void printll(Node head){
		Node temp = head;
		while ( temp.next != null){
			System.out.print(temp.data+" -> ");
			temp = temp.next;
		}
		System.out.print(temp.data);
	}
	Node prepLL(int... data){
			Node head = new Node(data[0]);
			Node prev = head;
			for( int i=1;i<data.length;i++){
				Node node = new Node(data[i]);
				prev.next = node;
				prev = node;
			}
			return head;
	}
		
	class Node{
		int data;
		Node next;
		public Node(){
		}
		public Node(int data){
			this.data = data;
		}
		public Node(int data, Node next){
			this();
			this.data  = data;
			this.next = next;
		}
		public int getData(){
			return this.data;
		}
		public Node getNext(){
			return this.next;
		}
		public void setData(int data){
			this.data = data;
		}
		public void setNext(Node next){
			this.next = next;
		}
		public String toString(){
			return "Node [data = "+data+"next="+next+"]";
		}
	}
}
