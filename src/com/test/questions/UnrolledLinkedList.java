package com.test.questions;

public class UnrolledLinkedList {
	
	public static void main(String[] args){
		int[] data = new int[]{1,2,3};
		int[] data2 = new int[]{4,5};
		NodeU node1 = new NodeU(data, null);
		NodeU node2 = new NodeU(data2, null);
		
		node1.setNext(node2);
		node2.setNext(null);
		
		NodeU head = node1;
		
		printData(head);
	}

	private static void printData(NodeU head) {
		while(head != null){
			int[] temp = head.data;
			for(int i=0; i<temp.length;i++){
				System.out.println(temp[i]);
			}
		   head = head.getNext();
		}
		
	}

}
