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
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //create a dummy node to start a new node as the res
            //at the end i will return dummy.next
            //iterative the l1 and l2
            //create a carry to record if l1.val + l2.val >= 10
            //use sum to calculate the sum
            //update carry by sum/10
            //create a new node to store sum%10
            //point cur to the new node
            //update cur to cur.next
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            int carry = 0;
            while(l1 != null || l2 != null) {
                int x = (l1 == null)? 0 : l1.val;
                int y = (l2 == null)? 0 : l2.val;
                int sum = x+y+carry;
                carry = sum/10;
                ListNode node = new ListNode(sum%10);
                cur.next = node;
                cur = cur.next;
                if(l1 != null) l1 = l1.next;
                if(l2 != null) l2 = l2.next;
            }
            if(carry != 0) {
                cur.next = new ListNode(carry);
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}