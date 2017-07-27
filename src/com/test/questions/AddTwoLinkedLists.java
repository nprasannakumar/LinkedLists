package com.test.questions;

public class AddTwoLinkedLists {
	
	public static void main(String[] args){
		ListNode root1 = new ListNode(5);
		ListNode node2 = new ListNode(5);
		//ListNode node3 = new ListNode(3);
		
		root1.next = node2;
		//node2.next = node3;
		node2.next = null;
		
		ListNode root2 = new ListNode(8);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(2);
		
		root2.next = node4;
		node4.next = node5;
		node5.next = null;
		int carry =0;
		System.out.println("whats linklist 1 data ? " +root1.data);
		System.out.println("whats linklist 2 data ? " +root2.data);
		//ListNode result = addLists(root1, root2, carry);
		
		ListNode result = addListsNonRecursive(root1, root2);
		while(result != null){
			System.out.println(result.data);
			result = result.next;
		}
		
	}

	// this works only when the 2 numbers add upto less 1000
	// the sum should be a 3 digit number  : not true
	// works for equal length lists
	private static ListNode addLists(ListNode root1, ListNode root2, int carry) {
		if(root1 == null && root2 == null && carry == 0){
			return null;
		}
		ListNode result = new ListNode(0);
		int value = carry;
		if(root1 != null){
			value += root1.data;
		}
		
		if(root2 != null){
			value += root2.data;
		}
		
		result.data = value % 10;
		
		if(root1 != null || root2 != null){
			ListNode more = addLists(root1 == null ? null : root1.next, 
								 root2 == null ? null : root2.next,
								 value >= 10 ? 1 : 0);
		
			result.next = more;
			//System.out.println("whats more? " +more.data);
			//System.out.println("whats the result ? " +result.data);
		}
		if(value == 1){
			ListNode node = new ListNode(1);
			node.next = result;
		}
		System.out.println(result.data);
		// lets print the result
		return result;
	}
	
	// awesome : after making changes
	// another way of solving the adding of 2 linked lists
	private static ListNode addListsNonRecursive(ListNode head1, ListNode head2){
		int carry = 0;
		int sum = 0;
		ListNode res = null;
		ListNode prev = null;
		ListNode temp = null;
		
		while(head1 != null || head2 != null){
			sum = carry + (head1 == null ? 0 : head1.data) + (head2 == null ? 0 : head2.data);
			
			carry = (sum >= 10) ? 1 : 0;
			sum = sum % 10;
			
			temp = new ListNode(sum);
			
			if(res == null){
				res = temp;
			}else{
				prev.next = temp;
			}
			
			prev = temp;
			
			if(head1 != null){
				head1 = head1.next;
			}
			
			if(head2 != null){
				head2 = head2.next;
			}
		}
		
		if(carry > 0){
			prev.next = new ListNode(carry);
		}
		
		return res;
	}
}
