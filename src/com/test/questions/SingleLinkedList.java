package com.test.questions;

public class SingleLinkedList {
	
	public static void main(String[] args){
		Node node3 = new Node(40, null);
		Node node2 = new Node(30, null);
		Node node1 = new Node(20, null);
		Node head = new Node(10, null);
		
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		//node3.setNext(null);
		node2.setNext(node1);
		
		boolean cycle = isCyclic(head);
		System.out.println("is cycle ? " +cycle);
		
	}
	
	public static boolean hasCycle(Node head){
		if(head == null){
			return false;
		}
		Node first = head;
		Node second = head;
		
		while(first.getNext() != null){
			first = first.getNext();
			
			if(second == null || second.getNext() == null){
				return false;
			}
			second = second.getNext().getNext();
			
			if(first == second){
				return true;
			}
		}
		return false;
	}
	public static boolean isCyclic(Node head)
	{ 
	Node fast = head;
	Node slow = head; 
	while(fast!= null && fast.getNext() != null)
	{ fast = fast.getNext().getNext(); 
	slow = slow.getNext(); //if fast and slow pointers are meeting then LinkedList is cyclic 
	if(fast == slow )
	{ 
		return true;
	} 
	} 
	return false; 
	}

	//Read more: http://javarevisited.blogspot.com/2013/05/find-if-linked-list-contains-loops-cycle-cyclic-circular-check.html#ixzz4d4q87q2i

}
