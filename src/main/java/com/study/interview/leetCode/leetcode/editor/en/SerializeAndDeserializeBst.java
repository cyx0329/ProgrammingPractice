//Serialization is converting a data structure or object into a sequence of bits
// so that it can be stored in a file or memory buffer, or transmitted across a ne
//twork connection link to be reconstructed later in the same or another computer 
//environment. 
//
// Design an algorithm to serialize and deserialize a binary search tree. There 
//is no restriction on how your serialization/deserialization algorithm should wor
//k. You need to ensure that a binary search tree can be serialized to a string, a
//nd this string can be deserialized to the original tree structure. 
//
// The encoded string should be as compact as possible. 
//
// 
// Example 1: 
// Input: root = [2,1,3]
//Output: [2,1,3]
// Example 2: 
// Input: root = []
//Output: []
// 
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// 0 <= Node.val <= 104 
// The input tree is guaranteed to be a binary search tree. 
// 
// Related Topics Tree 
// 👍 1655 👎 88


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBst {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Codec solution = new SerializeAndDeserializeBst().new Codec();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "";
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            System.out.print(sb.toString());
            return sb.toString().trim();
        }

        private void serialize(TreeNode node, StringBuilder sb) {
            if(node == null) return;
            sb.append(node.val).append(",");
            serialize(node.left, sb);
            serialize(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == null || data.length() == 0) return null;
            String[] nodes = data.split(",");
            Queue<String> q = new LinkedList<>(Arrays.asList(nodes));
            return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode deserialize(Queue<String> q, int low, int high) {
            if(q.isEmpty()) return null;
            String s = q.peek();
            int val = Integer.valueOf(s);
            if(val < low || val > high) return null;
            q.poll();
            TreeNode root = new TreeNode(val);
            root.left = deserialize(q, low, val);
            root.right = deserialize(q, val, high);
            return root;
        }

    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}