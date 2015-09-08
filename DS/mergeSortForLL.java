public class mergeSortForLL{
	public class LinkNode{
		int val;
		LinkNode next;
		LinkNode(int val){
			this.val  = val ;
			this.next = null;
		}
	}
	public static LinkNode mergeSort(LinkNode head){
		if( head == null || head .next == null )
			return head;
		int count = 0;
		LinkNode h = head ;
		while(h != null){
			count++ ;
			h = h.next ;	
		}
		int middle = count / 2;
		LinkNode l = head ;
		LinkNode r = null;
		LinkNode p = head ;
		int countHalf = 0;
		while(p != null ){
			countHalf++ ;
			LinkNode next = p.next ;
			if( countHalf != middle ){
				p.next = null;
				r = next ;
			}
			p = next ;
		}
		LinkNode h1 = mergeSort(l);
		LinkNode h2 = mergeSort(r);

		LinkNode merged = merged(h1,h2);

		return merged;
	}
	public static LinkNode merged(LinkNode l,LinkNode r){
		LinkNode p1  = l;
		LinkNode p2 = r;
		mergeSortForLL mg1 = new mergeSortForLL();
		
		LinkNode tempHead = mg1.new LinkNode(100);
		LinkNode pNew = tempHead ;
		
		while( p1 != null || p2 != null){
			if(p1 == null){
				pNew.next = mg1.new LinkNode(p2.val);
				p2 = p2.next;
				pNew = pNew.next;
			}
			else if(p2 == null){
				pNew.next = mg1.new LinkNode(p1.val);
				p1 = p1.next;
				pNew = pNew.next;
			}
			else{
				if(p1.val < p2.val){
					pNew.next = mg1.new LinkNode(p1.val);
					p1 = p1.next;
					pNew = pNew.next;
				}
				else if (p1.val == p2.val){
					pNew.next = mg1.new LinkNode(p1.val);
					pNew.next.next = mg1.new LinkNode(p2.val);
					p1 = p1.next;
					p2 = p2.next;
					pNew = pNew.next.next;
				}
				else{
					pNew.next = mg1.new LinkNode(p2.val);
					p2 = p2.next;
					pNew = pNew.next;
				}
				
			}
		}
		return tempHead.next;
	}
	public static void main(String[] args) {
		LinkNode n1 = new LinkNode(2);
		LinkNode n2 = new LinkNode(3);
		LinkNode n3 = new LinkNode(4);
 
		LinkNode n4 = new LinkNode(3);
		LinkNode n5 = new LinkNode(4);
		LinkNode n6 = new LinkNode(5);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
 
		n1 = mergeSort(n1);
 
		printList(n1);
	}
 
	public static void printList(LinkNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}
}
