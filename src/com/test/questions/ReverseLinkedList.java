package com.test.questions;

import java.util.HashSet;
import java.util.Set;

public class ReverseLinkedList {
	
	public static void main(String[] args){
		ListNode head1 = new ListNode(2);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		
		head1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		
		//head1.setNext(node1);
		//node1.setNext(node2);
		//node2.setNext(node3);
		//node3.setNext(null);
		
		ListNode root = head1;
		while(root != null){
			System.out.println(root.data);
			root = root.next;
		}
		
//		ListNode node = reverseLinkedlist(head1);
//		ListNode currNode = node;
//		while(currNode!=null){
//			System.out.print("->" + currNode.data);
//			currNode=currNode.next;
//		}
		
		ListNode node = removeDupsFromLinkedList(head1);
		ListNode currNode = node;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}
		
	}
	
	// 1->2->3->null
	// 1->null
	// 
	public static ListNode reverseLinkedlist(ListNode head){
		ListNode cur = head;
		ListNode next = null;
		ListNode prev = null;
		
		while(cur != null){
			next = cur.next;
			//Node temp = cur.getNext();
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		head = prev;
		
		// print the new reversed linked list
		return head;
	}
	
	// remove duplicates in a linked list
	// O(n), O(n) space and time 
	public static ListNode removeDupsFromLinkedList(ListNode head){
		Set<Integer> setOfUnqiues = new HashSet<Integer>();
		ListNode curr = head;
		ListNode prev = null;
		while(curr != null){
			if(!setOfUnqiues.contains(curr.data)){
				setOfUnqiues.add(curr.data);
				prev = curr;
				curr = curr.next;
			}else{
				prev.next = curr.next;
				curr = curr.next;
			}
		}
		return head;	
	}
	
	// add 2 linked lists

}
