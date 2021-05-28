/*List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
*/

import java.util.*;

public class MinimalTree{
	
	public static void main(String args[]){
		int[] arr = {2, 4, 6, 8, 10, 20};
		int n = arr.length;
		Node root =  computeGraph(null, arr);
		inOrderTraversal(root);
		ArrayList<LinkedList<Node>> depthsList = new ArrayList<LinkedList<Node>>();
		computeListOfDepths(root, 0, depthsList);
		int level = 0;
		for(LinkedList<Node> list : depthsList){
			System.out.println("\nLevel " + level++ );
			for(Node node: list){
				System.out.print(node.value + " ");
			}
		}
	}
	
	public static void computeListOfDepths(Node c, int depth, ArrayList<LinkedList<Node>> depthsList){
		if (c == null){
			return;
		}
				
		LinkedList<Node> list;
		System.out.println(depthsList.size());
		if (depthsList.size() <= depth){
			list = new LinkedList<Node>();
		} else{
			list = depthsList.get(depth);
			depthsList.remove(depth);
		}
		
		list.add(c);
		depthsList.add(list);
		int nextDepth = depth + 1;
		computeListOfDepths(c.left, nextDepth, depthsList);
		computeListOfDepths(c.right, nextDepth, depthsList);
	}	
	
	public static Node computeGraph(Node c, int[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		int n = arr.length;
		if (c == null){
			c = new Node(arr[n/2]);
		}
		if (n/2 > 0){
			c.left = computeGraph(c.left, Arrays.copyOfRange(arr, 0, n/2));

		}
		if (n > 1){
			c.right = computeGraph(c.right, Arrays.copyOfRange(arr, n/2 + 1, n));
		}
		return c;
	}
	
	static void inOrderTraversal(Node node){
		if(node != null){
			inOrderTraversal(node.left);
			System.out.print(node.value + " ");
			inOrderTraversal(node.right);
		}
	}
	
	static void preOrderTraversal(Node node){
		if(node != null){
			System.out.print(node.value + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	static void postOrderTraversal(Node node){
		if(node != null){
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node + " ");
		}
	}
}

class Node{
	int value;
	Node left;
	Node right;
	
	Node (int value){
		this.value = value;
	}
	
}