//Given the root of a binary tree, return the inorder traversal of its nodes' va
//lues. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [1,3,2]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// Example 4: 
//
// 
//Input: root = [1,2]
//Output: [2,1]
// 
//
// Example 5: 
//
// 
//Input: root = [1,null,2]
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//
// Follow up: 
//
// Recursive solution is trivial, could you do it iteratively? 
//
// 
// Related Topics Hash Table Stack Tree 
// 👍 3730 👎 156


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() { }
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            /*
            List<Integer> res = new ArrayList<>();
            if(root == null) return res;
            traversal(root, res);
            return res;
            */

            List<Integer> res = new ArrayList<>();
            if(root == null) return res;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while(node != null || !stack.isEmpty()) {
                while(node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
            return res;
        }

        private void traversal(TreeNode node, List<Integer> res) {
            if(node == null) return;
            traversal(node.left, res);
            res.add(node.val);
            traversal(node.right, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}