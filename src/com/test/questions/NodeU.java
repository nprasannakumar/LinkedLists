package com.test.questions;

public class NodeU {
	
	int[] data;
	NodeU next;
	
	public NodeU(int[] data, NodeU next){
		this.data = data;
		this.next = next;
	}
	public int[] getData() {
		return data;
	}
	public void setData(int[] data) {
		this.data = data;
	}
	public NodeU getNext() {
		return next;
	}
	public void setNext(NodeU next) {
		this.next = next;
	}


}
