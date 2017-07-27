package com.test.questions;
/**
 * Node contains data and a pointer to the next
 */
public class Node {
	private int data;
	private Node next;
	
	public Node(int data, Node next){
		this.setData(data);
		this.setNext(next);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}


}
