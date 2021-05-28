/*
Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
(that is, pop ( ) should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.
*/

import java.util.*;

public class SetOfStacks<T> {
	private final int THRESHOLD = 3;
	private ArrayList<MyStack<T>> stacks;	
	
	protected void push(T value){
		if (stacks == null){
			stacks = new ArrayList<MyStack<T>>();
		}
		int size = stacks.size();
		MyStack currentStack;
		if (size == 0){
			currentStack = new MyStack();
		}else{
			currentStack = stacks.get(size - 1);
			if (currentStack.isFull()){
					currentStack = new MyStack();
			}else{
				stacks.remove(size - 1); 
			}
		}
		currentStack.push(value);
		stacks.add(currentStack);	
	}
	
	protected T pop(){
		if(stacks == null || stacks.size() == 0){
			throw new EmptyStackException();
		}
		MyStack currentStack = stacks.get(stacks.size() - 1); 	
		
		var valueToReturn = currentStack.pop();
		if (currentStack.isEmpty()){
			stacks.remove(stacks.size() - 1);
		}
		return (T)valueToReturn;
	}
	
	
	
	public static void main(String args[]){
	
	SetOfStacks<Integer> setOfStacks = new SetOfStacks<Integer>();
	
	setOfStacks.push(2);
	setOfStacks.push(4);
	setOfStacks.push(3);
	setOfStacks.push(5);
	setOfStacks.push(6);
	setOfStacks.push(7);
	setOfStacks.push(8);
	setOfStacks.push(9);
	setOfStacks.push(0);
	setOfStacks.push(9);
	setOfStacks.push(8);
	
	//setOfStacks.printAll();
	System.out.println(setOfStacks.pop());	
	//setOfStacks.printAll();
	System.out.println(setOfStacks.pop());
	System.out.println(setOfStacks.pop());
	System.out.println(setOfStacks.pop());
	System.out.println(setOfStacks.pop());
	System.out.println(setOfStacks.pop());
	//setOfStacks.printAll();
	}	
}

class MyStack<T> {
	private class Node<T>{
		Node<T> next;
		T value;
		
		Node (T value){
			this.value = value;
			this.next = null;
		}
	}
	
	Node<T> top;
	private final int THRESHOLD = 3;
	private int noOfElements;
	{
		noOfElements = 0;
	}
	
	protected void push(T value){
		Node<T> c = new Node(value);
		if (top == null){
			top = c;
		}else{
			c.next = top;
			top = c;
		}
		noOfElements++;
	}
	
	protected boolean isEmpty(){
		return top==null;
	}
	protected boolean isFull(){
		return noOfElements == THRESHOLD;
	}
	
	protected T pop(){
		if (top == null){
			throw new EmptyStackException();
		}
		T value = top.value;
		top = top.next;
		noOfElements--;
		return value;
	}
}