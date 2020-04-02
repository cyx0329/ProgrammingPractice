//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics Linked List Math


package com.study.interview.leetCode.leetcode.editor.en;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            int carry = 0;
            ListNode p = l1, q = l2;
            while(p != null || q != null) {
                int x = (p == null) ? 0 : p.val;
                int y = (q == null) ? 0 : q.val;
                int sum = x + y + carry;
                carry = sum/10;
                curr.next = new ListNode(sum%10);
                curr = curr.next;
                if(p != null) p = p.next;
                if(q != null) q = q.next;
            }
            if(carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}