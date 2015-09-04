import java.util.*;

public class verticalSum {
	public static class node{
		int data;
		node right;
		node left;
		
		public node(int data){
			this.data = data;
			this.right = null;
			this.left = null;
		}
		public int getData(){
			return this.data;
		}
		public node getLeft(){
			return this.left;
		}
		public node getRight(){
			return this.right;
		}
		public void setData(int data){
			this.data = data;
		}
		public void setLeft(node n){
			this.left = n;
		}
		public void setRight(node n){
			this.right = n;
		}
	}
	public static void findVD(node root){
		if(root == null) {return;}
		else{
			HashMap<Integer,Integer> hM = new HashMap<>();
			verticalDistance(root,0,hM);
			if(hM != null){
				System.out.println("result"+hM.entrySet());
			}
		}
	}
	public static void verticalDistance(node root, int hD,HashMap<Integer,Integer> hM){
		if(root == null) {return;}
		
		verticalDistance(root.getLeft(),hD-1,hM);
		int preVal = (hM.get(hD) == null) ? 0 :hM.get(hD);
		hM.put(hD, preVal+root.data);
		verticalDistance(root.getRight(),hD+1,hM);
	}
	
	public static void main(String args[]){
		
		node one = new node(1);
		node two = new node(2);
		node three = new node(3);
		node four = new node(4);
		node five = new node(5);
		node six = new node(6);
		node seven = new node(7);
		
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(seven);
		three.setRight(six);
		findVD(one);
	}

}

