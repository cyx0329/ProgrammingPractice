//Design and implement a data structure for Least Frequently Used (LFU) cache. I
//t should support the following operations: get and put. 
//
// get(key) - Get the value (will always be positive) of the key if the key exis
//ts in the cache, otherwise return -1. 
//put(key, value) - Set or insert the value if the key is not already present. W
//hen the cache reaches its capacity, it should invalidate the least frequently us
//ed item before inserting a new item. For the purpose of this problem, when there
// is a tie (i.e., two or more keys that have the same frequency), the least recen
//tly used key would be evicted. 
//
// Note that the number of times an item is used is the number of calls to the g
//et and put functions for that item since it was inserted. This number is set to 
//zero when the item is removed. 
//
// 
//
// Follow up: 
//Could you do both operations in O(1) time complexity? 
//
// 
//
// Example: 
//
// 
//LFUCache cache = new LFUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.get(3);       // returns 3.
//cache.put(4, 4);    // evicts key 1.
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
// 
//
// 
// Related Topics Design


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.HashMap;

public class LfuCache {

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        HashMap<Integer, Node> map;
        HashMap<Integer, DLList> freqMap;
        int capacity;
        int maxFreq;

        public LFUCache(int capacity) {
            map = new HashMap<>(capacity);
            freqMap = new HashMap<>();
            this.capacity = capacity;
            maxFreq = 0;
        }

        public int get(int key) {
            if(!map.containsKey(key)) return -1;
            Node node = map.get(key);
            int prevFreq = node.freq;
            DLList prevList = freqMap.get(prevFreq);
            prevList.remove(node);

            int curFreq = prevFreq+1;
            maxFreq = Math.max(maxFreq, curFreq);
            DLList curList = freqMap.getOrDefault(curFreq, new DLList());
            node.freq++;
            curList.addHead(node);

            freqMap.put(prevFreq, prevList);
            freqMap.put(curFreq, curList);

            return node.value;
        }

        public void put(int key, int value) {
            if(capacity == 0) return;
            if(map.containsKey(key)) {
                map.get(key).value = value;
                get(key);
                return;
            }

            Node node = new Node(key, value);
            DLList curList = freqMap.getOrDefault(1, new DLList());
            curList.addHead(node);

            if(map.size() > capacity) {
                if(curList.len > 1) {
                    curList.removeTail();
                } else {
                    for(int i = 2; i <= maxFreq; i++) {
                        if(freqMap.get(i) != null && freqMap.get(i).len > 0) {
                            freqMap.get(i).removeTail();
                            break;
                        }
                    }
                }
            }
            freqMap.put(1, curList);
        }

        class Node {
            int key, value, freq;
            Node prev, next;
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.freq = 1;
            }
        }

        class DLList {
            Node head, tail;
            int len;
            public DLList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
                len = 0;
            }

            public void addHead(Node node) {
                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
                map.put(node.key, node);
                len++;
            }

            public void remove(Node node) {
                Node prev = node.prev;
                Node next = node.next;
                next.prev = prev;
                prev.next = next;
                map.remove(node.key);
                len--;
            }

            public void removeTail() {
                Node prevTail = tail.prev;
                remove(prevTail);
            }
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}