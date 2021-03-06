import java.util.Queue;
import java.util.LinkedList;
public class TreeTraverse
{
 private static class Node
 {
  public Node left; 
  public Node right;
  public String data;
  public Node( String data)
  {
   this.data = data;
  }
  public Node getLeft()
  {
   return this.left;
  }
  public void setLeft(Node left)
  {
   this.left = left;
  }
  public Node getRight()
  {
   return this.right;
  }
  public void setRight(Node right)
  {
   this.right = right;
  }
 }
public static int findLevel(Node n,Node a,int d){ 
	if(n== null) 
		return -1;
	else{
		if(Integer.parseInt(n.data) == Integer.parseInt(a.data))
			return d;
		else if(Integer.parseInt(n.data) < Integer.parseInt(a.data))
			return findLevel(n.left,a,d+1);
		return findLevel(n.right,a,d+1);
	}
}
public static int findLCDistance(Node root, Node a,Node b){
	Node lca = LCA(root,a,b);
	int d1 = findLevel(lca,a,0);
	int d2 = findLevel(lca,b,0);
		if(d1 !=-1 && d2 !=-1)
			return d1+d2;
		else
			return -1;
}
public static Node LCA(Node root, Node a, Node b) {
   if (root == null) {
       return null;
   }
   if (root == a || root == b) {
       return root;
   }
   Node left = LCA(root.left, a, b);
   Node right = LCA(root.right, a, b);
   if (left != null && right != null) {
      return root;
   }

   return (left != null) ? left : right; 
}
 public static void preorder(Node n)
 {
  if (n != null)
  {
   System.out.print(n.data + " ");
   preorder(n.getLeft());
   preorder(n.getRight());
  }
 }
 public static void inorder(Node n)
 {
  if (n != null)
  {
   inorder(n.getLeft());
   System.out.print(n.data + " ");
   inorder(n.getRight());
  }
 }
 public static void postorder(Node n)
 {
  if (n != null)
  {
   postorder(n.getLeft());
   postorder(n.getRight());
   System.out.print(n.data + " ");
  }
 }
 public static Node invert(Node n){
	if(n!=null){
		Node temp = n.left;
		n.left = n.right;
		n.right = temp;
		 
		if(n.left != null)
			invert(n.left);
		if(n.right != null)
			invert(n.right);
		
	}
	return n;
 }
 public static void levelorder(Node n)
 {
  Queue<Node> nodequeue = new LinkedList<Node>();
  if (n != null)
   nodequeue.add(n);
  while (!nodequeue.isEmpty())
  {
   Node next = nodequeue.remove();
   System.out.print(next.data + " ");
   if (next.getLeft() != null)
   {
    nodequeue.add(next.getLeft());
   }
   if (next.getRight() != null)
   {
    nodequeue.add(next.getRight());
   }
  }
 }
 public static void main(final String[] args)
 {
  Node one = new Node("1");
  Node two = new Node("2");
  Node three = new Node("3");
  Node four = new Node("4");
  Node five = new Node("5");
  Node six = new Node("6");
  Node seven = new Node("7");
  Node eight = new Node("8");
  Node nine = new Node("9");
  six.setLeft(four);
  six.setRight(seven);
  four.setLeft(three);
  four.setRight(five);
  three.setLeft(one);
  three.setRight(two);
  seven.setLeft(eight);
  seven.setRight(nine);
  System.out.print("Pre-order \t:");
  preorder(six);
  System.out.println();
  System.out.print("In-order \t:");
  inorder(six);
  System.out.println();
  System.out.print("Post-order \t:");
  postorder(six);
  System.out.println();
  System.out.print("Level-order \t:");
  levelorder(six);
  invert(six);
  System.out.print("\nPre-order after tree inversion \t:"); 
  preorder(six);
  Node n = LCA(six,one,nine);
  System.out.print("\nLowest Common Ancestor \t: "+n.data+"\n");
  int d = findLCDistance(six ,one,nine);
  System.out.print("The least distance between 2 nodes is ="+d);
  System.out.println();
 }
}
