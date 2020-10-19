//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
//estriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this st
//ring can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode serializes
// a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
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
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Design 
// 👍 3513 👎 169


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Codec solution = new SerializeAndDeserializeBinaryTree().new Codec();
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
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (node != null) {
                        sb.append(node.val).append(",");
                        q.add(node.left);
                        q.add(node.right);
                    } else {
                        sb.append("null,");
                    }
                }
            }
            return sb.toString().trim();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] nodes = data.split(",");
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
            q.add(root);
            for (int i = 1; i < nodes.length; ++i) {
                TreeNode parent = q.poll();
                if (!nodes[i].equals("null")) {
                    int val = Integer.valueOf(nodes[i]);
                    TreeNode left = new TreeNode(val);
                    parent.left = left;
                    q.add(left);
                }
                if (!nodes[++i].equals("null")) {
                    int val = Integer.valueOf(nodes[i]);
                    TreeNode right = new TreeNode(val);
                    parent.right = right;
                    q.add(right);
                }
            }
            return root;
        }
        /*
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#").append(",");
            } else {
                sb.append(root.val).append(",");
                serialize(root.left, sb);
                serialize(root.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(q);
        }

        public TreeNode deserialize(Queue<String> q) {
            String s = q.poll();
            if (s.equals("#")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(s));
            root.left = deserialize(q);
            root.right = deserialize(q);
            return root;
        }

         */
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}