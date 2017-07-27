package com.test.questions;

public class ScratchPad {

	public static void main(String[] args) {
		Node head1 = new Node(1, null);
		Node node1 = new Node(2, null);
		Node node2 = new Node(3, null);
		Node node3 = new Node(4, null);
		Node node4 = new Node(5, null);
		Node node5 = new Node(6, null);
		
		head1.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		
		Node head2 = new Node(10, null);
		Node node6 = new Node(15, null);
		head2.setNext(node6);
		node6.setNext(node4);
		
		
		int intersectedNode = getIntersectionOfLists(head1, head2);
		System.out.println("intersected node is : " +intersectedNode);
		
		
		//Node curr = head;
		
		
		
		//do{
			//System.out.println("Node : " +curr.getData());
			//curr = curr.getNext();
		//}while(curr!=null);
		//insertNodeAtEnd(head, node5);
		
		//Node result = insertNodeAtHead(head, node5);
		//System.out.println("head is : " +result.getData());
		
		//insertNodeAtKthPosition(head, node5);
		
		//removeHeadOfList(head);
		
		//Node lastNode = deleteNodeAtEnd(head);
		//System.out.println("last node is " +lastNode.getData());
		//Node cur = head;
		//removeKthNodeFromList(head);
//		while(cur != null){
//			System.out.println("after : " +cur.getData());
//		}
		
		//searchForAnElementInList(head, node5);
		}
		
		

	private static boolean searchForAnElementInList(Node head, Node node5) {
		// search for an element in a linked list, if found return true else false
		// check if the element is not null
		// head is not null
		// iterate through the list to find the element.. worst case o(n)
		// best case ?
		Node curr = head;
		while(curr.getNext() != null){
			if(curr.getData() == node5.getData()){
				System.out.println("found data : "+curr.getData());
				return true;
			}
			else{
				curr = curr.getNext();
			}
		}
		return false;
	}

	private static Node removeKthNodeFromList(Node head) {
		//remove kth element from the list
		// is k a positive integer? if not, what should I do
		// if k is not within the list? what should be done?
		// what is k? say suppose k is 2 i.e remove the 2nd item from the list
		// assume head starts at pos 0
		// delete data 3
		int pos = 0;
		Node curr = head;
		Node prev = head;
		if(head == null){
			return null;
		}

		while(curr != null){
			if(pos != 2){
				System.out.println("Node data is : " +curr.getData());
				prev = curr;
				curr = curr.getNext();
				pos = pos + 1;
			}else {
				prev.setNext(curr.getNext());
				//curr = curr.getNext();
				pos = pos + 1;
			}
		}
		return head;
	}

	private static Node deleteNodeAtEnd(Node head) {
		// remove last node in the list
		if(head == null){
			return null;
		}
		if(head.getNext() == null){
			return null;
		}
		Node curr = head;
		Node prev = head;
		while(curr.getNext() != null){
			prev = curr;
			curr = curr.getNext();
		}
		prev.setNext(null);
		return prev;
	}

	private static Node removeHeadOfList(Node head) {
		//delete node at head
		if(head == null){
			return null;
		}
		
		if(head.getNext() == null){
			return null;
		}
		head = head.getNext();
		System.out.println("head is" +head.getData());
		return head;
	}
	
	private static Node insertNodeAtKthPosition(Node head, Node node5) {
		// insert a node at kth position
		// is k a positive number ? if not, what should I do?
		// if k is not within the list? what should be done?
		// what is k? say k is 3.. assume pos starts at 0
		if(node5 == null){
			return head;
		}
		
		if(head == null){
			return null;
		}
		int pos=0;
		Node curr = head;
		while(curr != null){
			if(pos != 2){
				curr = curr.getNext();
				pos = pos + 1;
			} 
			else{
				Node next = curr.getNext();
				curr.setNext(node5);
				node5.setNext(next);
				pos = pos + 1;
				System.out.println("element at 3rd position is : " +curr.getNext().getData());
			}
		}
		return head;

	}

	private static Node insertNodeAtHead(Node head, Node node5) {
		// insert node at front of the list 
		// given is node 
		if(node5 == null){
			return head;
		}
		node5.setNext(head);
		return node5;
	
	}

	private static Node insertNodeAtEnd(Node head, Node node5) {
		if(head == null){
			return node5;
		}
		
		if(node5 == null){
			return head;
		}
		Node curr = head;
		while(curr.getNext() != null){
			Node next = curr.getNext();
			curr = next;
		}
		curr.setNext(node5);
		node5.setNext(null);
		
		System.out.println("end of list is : " +curr.getNext().getData());
		return head;
	}
	
	// given 2 linked lists, find the intersection of the 2 linked lists
	// eg list1 : 3->1->4->5->6->null
	// eg list2 : 5->10->null
	public static int getIntersectionOfLists(Node head1, Node head2){
		// calculate the length of the 2 lists : input : node output : length
		// iterate through the longer list : input : length, head of the longer list output : node 
		// iterate through both the lists and return the common intersection input : node1, node2 output : common node with data
		Node curr;
		int count1=0;
		int count2=0;
		count1 = getLengthOfList(count1,head1);
		count2 = getLengthOfList(count2,head2);
		
		if(count1 > count2){
			int diff = count1 - count2;
			return iterateOverLongerListAndGetIntersection(diff, head1, head2);
		}
		if(count2 > count1){
			int diff = count2 - count1;
			return iterateOverLongerListAndGetIntersection(diff, head2, head1);
		}
		return -1;
	}



	private static int iterateOverLongerListAndGetIntersection(int diff, Node head1, Node head2) {
		Node curr = head1;
		for(int i=0; i<diff; i++){
			curr = curr.getNext();
		}
		while(curr.getNext() != null && head2.getNext() != null){
			if(curr.getNext() == head2.getNext()){
				return curr.getNext().getData();
			}
			curr = curr.getNext();
			head2 = head2.getNext();
		}
		return -1;
	}



	private static int getLengthOfList(int count, Node head) {
		while(head != null){
			count = count + 1;
			head = head.getNext();
		}
		return count;
	}

}
