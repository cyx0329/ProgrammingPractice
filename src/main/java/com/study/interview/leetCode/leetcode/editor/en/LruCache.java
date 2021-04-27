//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise ret
//urn -1. 
// void put(int key, int value) Update the value of the key if the key exists. O
//therwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key. 
// 
//
// Follow up: 
//Could you do get and put in O(1) time complexity? 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// At most 3 * 104 calls will be made to get and put. 
// 
// Related Topics Design 
// 👍 6914 👎 290


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        class DLinkedListNode {
            int key;
            int value;
            DLinkedListNode prev;
            DLinkedListNode next;
        }

        private void addNode(DLinkedListNode node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        private void removeNode(DLinkedListNode node) {
            DLinkedListNode prev = node.prev;
            DLinkedListNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DLinkedListNode node) {
            removeNode(node);
            addNode(node);
        }

        private DLinkedListNode popTail() {
            DLinkedListNode node = tail.prev;
            removeNode(node);
            return node;
        }

        private Map<Integer, DLinkedListNode> cache;
        private int capacity;
        private DLinkedListNode head;
        private DLinkedListNode tail;

        public LRUCache(int capacity) {
            cache = new HashMap<>();
            this.capacity = capacity;
            head = new DLinkedListNode();
            tail = new DLinkedListNode();
            head.next = tail;
            tail.prev = head;
        }



        public int get(int key) {
            DLinkedListNode node = cache.get(key);
            if(node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedListNode node = cache.get(key);
            if(node == null) {
                node = new DLinkedListNode();
                node.key = key;
                node.value = value;
                cache.put(key, node);
                addNode(node);
                if(cache.size() > capacity) {
                    DLinkedListNode removeNode = popTail();
                    cache.remove(removeNode.key);
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
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