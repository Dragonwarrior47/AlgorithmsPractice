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
	
	public static Node<String> constructFromPostOrder(List<String> inorder, List<String> postorder){
		Map<String, Integer> inorderIndex = new HashMap<>();
		for(int i=0; i<inorder.size(); i++){
			inorderIndex.put(inorder.get(i), i);
		}
		return constructFromPostOrderHelper(0, inorder.size()-1, 0, postorder.size()-1, postorder, inorderIndex);
	}
	
	public static Node<String> constructFromPostOrderHelper(int inorder_start, int inorder_end, int postorder_start, int postorder_end, List<String> postorder, Map<String, Integer>inorderIndex){
		if( inorder_start > inorder_end || postorder_start> postorder_end)
			return null;
		int rootIndex = inorderIndex.get(postorder.get(postorder_end));
		int leftSubtreeSize = rootIndex - inorder_start;
		Node<String> root = new Node(postorder.get(postorder_end));
		/**
		System.out.println("root data->"+ root.data);
		System.out.println(String.format("inorder_start:%s, inorder_end:%s, postorder_start:%s, postorder_end:%s, size:%s", inorder_start,
		inorder_end, postorder_start, postorder_end, postorder.size()));
		System.out.println(String.format("postorder left: %s", postorder.subList(postorder_start, postorder_start + leftSubtreeSize)));
		System.out.println(String.format("postorder right: %s", postorder.subList(postorder_start + leftSubtreeSize, postorder_end-1))); 
		*/
		root.left = constructFromPostOrderHelper(inorder_start, rootIndex-1, postorder_start, postorder_start+leftSubtreeSize-1, postorder, inorderIndex);
		root.right = constructFromPostOrderHelper(rootIndex+1, inorder_end, postorder_start+leftSubtreeSize, postorder_end-1, postorder, inorderIndex);
		return root;
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
		List<String> inorder = new ArrayList<>(List.of("F", "B", "A", "E","H", "C", "D", "I", "G"));
		List<String> postorder = new ArrayList<>(List.of("F", "A", "E", "B", "I", "G", "D", "C", "H"));
		Node<String> root = constructFromPostOrder(inorder, postorder);
		inorder(root);
		
	}

}
