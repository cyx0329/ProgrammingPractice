//You are given two non-empty linked lists representing two non-negative integer
//s. The most significant digit comes first and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Follow up: 
//What if you cannot modify the input lists? In other words, reversing the lists
// is not allowed.
// 
//
// 
//Example:
// 
//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7
// 
// Related Topics Linked List 
// 👍 1728 👎 168


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.Stack;

public class AddTwoNumbersIi {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        //follow up: don't reverse the lists
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<ListNode> s1 = new Stack<>();
            Stack<ListNode> s2 = new Stack<>();
            while(l1 != null) {
                s1.push(l1);
                l1 = l1.next;
            }
            while(l2 != null) {
                s2.push(l2);
                l2 = l2.next;
            }

            ListNode head = null;
            int carry = 0;
            while(!s1.isEmpty() || !s2.isEmpty()) {
                int x = (s1.isEmpty()) ? 0 : s1.pop().val;
                int y = (s2.isEmpty()) ? 0 : s2.pop().val;
                int sum = x+y+carry;
                carry = sum/10;
                ListNode cur = new ListNode(sum%10);
                cur.next = head;
                head = cur;
            }
            if(carry != 0) {
                ListNode cur = new ListNode(carry);
                cur.next = head;
                head = cur;
            }
            return head;

        }
        /* reverse the lists
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverseList(l1);
            l2 = reverseList(l2);
            ListNode head = null;
            int carry = 0;
            while(l1 != null || l2 != null) {
                int x = (l1 == null)? 0 : l1.val;
                int y = (l2 == null)? 0 : l2.val;
                int sum = x+y+carry;
                carry = sum/10;
                ListNode cur = new ListNode(sum%10);
                cur.next = head;
                head = cur;
                if(l1 != null) l1 = l1.next;
                if(l2 != null) l2 = l2.next;
            }
            if(carry != 0) {
                ListNode cur = new ListNode(carry);
                cur.next = head;
                head = cur;
            }
            return head;
        }

        private ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode prev = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
         */
    }
//leetcode submit region end(Prohibit modification and deletion)

}