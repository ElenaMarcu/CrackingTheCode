public class Node<T>{
	
	protected Node next;
	protected T data;
	
	public Node(T data){
		this.data = data;
		this.next = null;
	}
	
	public void appendToTail(T n){
		Node end = new Node(n);
		Node c = this;
		while (c.next != null){
			c = c.next;
		}
		
		c.next = end;
	}
	
	public void printList(){
		Node c = this;
		while(c != null){
			System.out.print(c.data);
			c = c.next;
		}
	}
}