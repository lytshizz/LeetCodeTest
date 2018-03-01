package com.yst.test;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
//		l2.next.next = new ListNode(4);
		
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode l3 = addTwoNumbers.addTwoNumbers(l1, l2);
		while(null != l3) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	/**
	 * 方法一：通过逐位获取，进行判断加上进位是否大于10，大于10要记录进位信息，最后通过String字符串的形式输出
	 * @param l1
	 * @param l2
	 * @return
	 * @author yst
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int num1 = 0, num2 = 0;
		int sum = 0;
		int i = 0;  // 进位
		int count = 0; // 
		ListNode l3 = new ListNode(0);
		ListNode resultNode = new ListNode(0);
		resultNode.next = l3;
		StringBuffer sb = new StringBuffer();
		while(null != l1 || null != l2) {
			if(null != l1) {
				num1 = l1.val;
				l1 = l1.next;
			}
			if(null != l2) {
				num2 = l2.val;
				l2 = l2.next;
			}
			
			sum = num1 + num2 + i;
			sb.append(sum % 10);
			l3.val = sum % 10;
			i = sum >= 10 ? 1 : 0;
			num1 = 0;
			num2 = 0;
		}
		
		if(i > 0) {
			sb.append("1");
		}
		
		String sumStr = sb.toString();
		for(int index = 0; index < sumStr.length(); index++) {
			if(index == 0) {
				l3.val = Integer.parseInt(sumStr.substring(index, index + 1));
			}else {
				l3.next = new ListNode(Integer.parseInt(sumStr.substring(index, index + 1)));
				l3 = l3.next;
			}
		}
		
		return resultNode.next;
	}

}
