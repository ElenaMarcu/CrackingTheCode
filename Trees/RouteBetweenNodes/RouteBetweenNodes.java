/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes.
*/

import java.util.*;

public class RouteBetweenNodes{
			
	public static void findRoute(Node source, Node destination){
		if (source == null || destination == null){
			System.out.println("False");
			return;
		}
		source.visit();
		if (source.adjacent != null){
			for (Node adj : source.adjacent){
				if (adj!= null){
					if (adj == destination){
						System.out.println("true");
					}
					else{
						if (adj.marked == false){
							findRoute(adj, destination);
						}
					
					}
				}
			}
		}
	}
		

	public static void main(String[] args){
			Node root = new Node(0);
			Node r = new Node(1);
			Node r1 = new Node(2);
			Node r2 = new Node(3);
			Node r3 = new Node(4);
			Node r4 = new Node(5);
			Node[] adjroot = new Node[]{r, r3, r4};
			root.addAdjacents(adjroot);
			Node[] adjr = new Node[]{r2, r3};
			Node[] adjr1 = new Node[]{r};
			Node[] adjr2 = new Node[]{r1, r3};
			Node[] adjr3 = new Node[]{root, r, r2};
			r.addAdjacents(adjr);
			r1.addAdjacents(adjr1);
			r2.addAdjacents(adjr2);
			r3.addAdjacents(adjr3);
			findRoute(r,r4);
			
	}	
}

		class Node{
			int name;
			Node[] adjacent;
			boolean marked;
			
			Node (int name){
				this.name = name;
			}
			
			public void addAdjacents (Node[] adj){
				this.adjacent = adj;
			}
			
			public void visit(){
				this.marked = true;
			}
		}
		

class Graph {
		Node root;
		
		Graph(Node n){
			root = n;
		}
	}