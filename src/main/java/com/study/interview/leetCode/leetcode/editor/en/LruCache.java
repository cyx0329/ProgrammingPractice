//Design and implement a data structure for Least Recently Used (LRU) cache. It 
//should support the following operations: get and put. 
//
// get(key) - Get the value (will always be positive) of the key if the key exis
//ts in the cache, otherwise return -1. 
//put(key, value) - Set or insert the value if the key is not already present. W
//hen the cache reached its capacity, it should invalidate the least recently used
// item before inserting a new item. 
//
// The cache is initialized with a positive capacity. 
//
// Follow up: 
//Could you do both operations in O(1) time complexity? 
//
// Example: 
//
// 
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
// 
//
// 
// Related Topics Design


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.HashMap;

public class LruCache {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

    class LRUCache {
        HashMap<Integer, Node> map;
        final Node head = new Node();
        final Node tail = new Node();
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            int result = -1;
            Node node = map.get(key);
            if(node != null) {
                result = node.val;
                remove(node);
                add(node);
            }
            return result;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if(node != null) {
                remove(node);
                node.val = value;
                add(node);
            } else {
                if(map.size() == capacity) {
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                }
                Node newNode = new Node();
                newNode.key = key;
                newNode.val = value;
                map.put(key, newNode);
                add(newNode);
            }

        }

        public void add(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}