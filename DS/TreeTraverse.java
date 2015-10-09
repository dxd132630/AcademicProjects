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
  one.setLeft(two);
  one.setRight(three);
  two.setLeft(four);
  two.setRight(five);
  three.setLeft(six);
  four.setLeft(seven);
  six.setLeft(eight);
  six.setRight(nine);
  System.out.print("Pre-order \t:");
  preorder(one);
  System.out.println();
  System.out.print("In-order \t:");
  inorder(one);
  System.out.println();
  System.out.print("Piost-order \t:");
  postorder(one);
  System.out.println();
  System.out.print("Level-order \t:");
  levelorder(one);
  invert(one);
  System.out.print("\nPre-order after tree inversion \t:"); 
  preorder(one);
  System.out.println();
 }
}
