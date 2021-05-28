/*
Remove Dups: Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/

public class RemoveDups{
	
	public static void main(String[] args){
		Node<Character> n = new Node<Character>('a');
		n.appendToTail('l');
		n.appendToTail('l');
		n.appendToTail('l');
		n.appendToTail('2');
		n.appendToTail('3');
		n.appendToTail('4');
		n.printList();
		Node copy = n;
		while(n.next != null){
			Node c = n.next;
			while (c != null && n.data == c.data){
				n.next = c.next;
				c = c.next;
			}
			n = n.next;
		}
		copy.printList();
		
	}
	
}