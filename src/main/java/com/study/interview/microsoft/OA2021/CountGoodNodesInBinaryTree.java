package com.study.interview.microsoft.OA2021;

public class CountGoodNodesInBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static void main(String[] args) {
    }

    private int countGoodNodesInBinaryTree(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int val) {
        if(node == null) return 0;
        int max = Math.max(val, node.val);
        if(node.val >= max) {
            return 1 + dfs(node.left, max) + dfs(node.right, max);
        } else {
            return dfs(node.left, max) + dfs(node.right, max);
        }

    }

    //time complexity: O(n) where n is number of nodes in a binary tree since I visit each node once.
    //use dfs preorder recursively traverse a binary tree, the base case is when node is null, return null.
    //use max keep checking the max value in the current path.
    //if the current node val is greater than or equal to the current max value, which means this current node
    //is a good node, i count 1 in the return result and add up the results from continuing the dfs traversal;
    //otherwise, which means this current node is not a good node, then return the add up results from continuing
    //the dfs traversal
}
