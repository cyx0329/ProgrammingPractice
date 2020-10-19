//Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both? 
// Related Topics Linked List 
// 👍 5433 👎 102


package com.study.interview.leetCode.leetcode.editor.en;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() { }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
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
        //iterative
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode prev = null;
            while(cur != null) {
              ListNode next = cur.next;
              cur.next = prev;
              prev = cur;
              cur = next;
            }
            return prev;
        }

         /* recursive
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }
         */
    }
//leetcode submit region end(Prohibit modification and deletion)

}