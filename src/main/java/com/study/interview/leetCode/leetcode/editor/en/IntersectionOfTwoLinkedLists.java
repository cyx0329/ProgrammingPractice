//Write a program to find the node at which the intersection of two singly linke
//d lists begins. 
//
// For example, the following two linked lists: 
//
//
// begin to intersect at node c1. 
//
// 
//
// Example 1: 
//
//
// 
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2
//, skipB = 3
//Output: Reference of the node with value = 8
//Input Explanation: The intersected node's value is 8 (note that this must not 
//be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. F
//rom the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the inter
//sected node in A; There are 3 nodes before the intersected node in B. 
//
// 
//
// Example 2: 
//
//
// 
//Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skip
//B = 1
//Output: Reference of the node with value = 2
//Input Explanation: The intersected node's value is 2 (note that this must not 
//be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. F
//rom the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected
// node in A; There are 1 node before the intersected node in B.
// 
//
// 
//
// Example 3: 
//
//
// 
//Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//Output: null
//Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B
//, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 
//0, while skipA and skipB can be arbitrary values.
//Explanation: The two lists do not intersect, so return null.
// 
//
// 
//
// Notes: 
//
// 
// If the two linked lists have no intersection at all, return null. 
// The linked lists must retain their original structure after the function retu
//rns. 
// You may assume there are no cycles anywhere in the entire linked structure. 
// Each value on each linked list is in the range [1, 10^9]. 
// Your code should preferably run in O(n) time and use only O(1) memory. 
// 
// Related Topics Linked List 
// 👍 4259 👎 488


package com.study.interview.leetCode.leetcode.editor.en;

public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        //We can use two iterations to do that.
        // In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist after
        // it reaches the tail node. In the second iteration, we will move two pointers until
        // they points to the same node. Our operations in first iteration will help us counteract the difference.
        // So if two linkedlist intersects, the meeting point in second iteration must be the intersection point.
        // If the two linked lists have no intersection at all, then the meeting pointer in second iteration must
        // be the tail node of both lists, which is null
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode a = headA;
            ListNode b = headB;

            while (a != b) {
                a = (a == null) ? headB : a.next;
                b = (b == null) ? headA : b.next;
            }
            return a;
        }

        /*
        //1, Get the length of the two lists.
        //2, Align them to the same start point.
        //3, Move them together until finding the intersection point, or the end null
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = length(headA), lenB = length(headB);
            // move headA and headB to the same start point
            while (lenA > lenB) {
                headA = headA.next;
                lenA--;
            }
            while (lenA < lenB) {
                headB = headB.next;
                lenB--;
            }
            // find the intersection until end
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }

        private int length(ListNode node) {
            int length = 0;
            while (node != null) {
                node = node.next;
                length++;
            }
            return length;
        }
        */

    }
//leetcode submit region end(Prohibit modification and deletion)

}