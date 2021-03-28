import java.util.*;


public class BinaryTree{
	
	public static class Node<T>{
		T data;
		Node<T> left;
		Node<T> right;
		
		public  Node(T data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static <T> void inorder(Node<T> root){
		if(root != null){
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
	
	public static <T> boolean isSymmetricHelper(Node<T> left, Node<T> right){
		
		if (left == null && right != null)
			return false;
		if(right == null && left != null)
			return false;
		if(left == null && right == null)
			return true;
		if ((left.data == right.data) && (isSymmetricHelper(left.left, right.right)) && (isSymmetricHelper(left.right, right.left)))
			return true;
		else
			return false;
	}
	public static <T> boolean isSymmetric(Node<T> root){
		
			if (root == null)
				return true;
			return isSymmetricHelper(root.left, root.right);
	}

	public static void main(String args[]){
		
		Node<Integer> A = new Node<>(314);
		Node<Integer> B =  A.left = new Node<>(6);
		Node<Integer> E = A.right = new Node<>(6);
		Node<Integer> C = B.right = new Node<>(2);
		Node<Integer> F = E.left = new Node<>(2);
		Node<Integer> D = C.right = new Node<>(3);
		Node<Integer> G = F.left = new Node<>(4);
		boolean ans = isSymmetric(A);
		if (ans)
			System.out.println("Tree is Symmetrical.");
		else
			System.out.println("Tree is Asymmetrical.");
		
	}

}
