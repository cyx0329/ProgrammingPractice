//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search 
// 👍 4051 👎 109


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        //we clearly know the first element of preorder, so i will find this element inside inorder,
        //then i will get the index of this element, from that, the left side of this element is the left of the tree,
        //the right side of the element is the right side of the tree, then recursively to build the rest of the tree
        /*
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return helper(0, 0, inorder.length-1, preorder, inorder);
        }

        private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
            if(preStart > preorder.length || inStart > inEnd) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preStart]);
            int root_index = 0;
            for(int i = inStart; i <= inEnd; i++) {
                if(inorder[i] == root.val) {
                    root_index = i;
                }
            }

            root.left = helper(preStart+1, inStart, root_index-1, preorder, inorder);
            root.right = helper(preStart+1+root_index- inStart, root_index+1, inEnd, preorder, inorder);

            return root;
        }
        */
        //O(n^2) for each element in preOrder, we search O(n) in inorder
        //one improvement we can do here: we can use a hashMap to memorize the index of root in inorder array
        //that will save time O(n)

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return helper(0, 0, inorder.length-1, preorder, map);
        }

        private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder,
                                HashMap<Integer, Integer> map) {
            if(preStart > preorder.length || inStart > inEnd) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preStart]);
            int root_index = map.get(root.val);

            root.left = helper(preStart+1, inStart, root_index-1, preorder, map);
            root.right = helper(preStart+1+root_index- inStart, root_index+1, inEnd, preorder, map);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}