import java.util.*;

public class stackUsingQueue{
	static Queue<Integer> q;
	static Queue<Integer> tmp;

	public stackUsingQueue(){
		q = new LinkedList<Integer>();
		tmp = new LinkedList<Integer>();
	}
	public static void peek(){
		if(q.size() >0)
			System.out.println("top ele is :"+q.peek());
	}
	public static boolean isEmpty(){
		if(q.size()==0)
			return true;
		else
			return false;
	}
	public static int getSize(){
		return q.size();
	}
	public static void push(int data){
		if(q.size() ==0)
			q.add(data);
		else{
			int l = q.size();
			for(int i=0;i<l;i++){
				tmp.add(q.remove());
			}
			q.add(data);
			for(int i=0;i<l;i++)
				q.add(tmp.remove());
		}
		System.out.println("added item :"+data);
	}
	public static void pop(){
		if(q.size() >0){
			System.out.println("popped element is "+q.remove());
		}
		else
			System.out.println("stack is empty");
	}
	public static void main(String args[]){
		stackUsingQueue sq = new stackUsingQueue();
		sq.push(1);
		sq.push(2);
		sq.pop();
		sq.push(4);
		sq.push(3);
		sq.pop();
		
	}
}

