package com.study.interview.google.phone;

import java.util.LinkedList;

/*
    Design a data structure to calculate the moving product of all elements in a sliding window of size k.

    class SlidingWindow {

        public SlidingWindow(int k) {
        }

        public void add(int val) {
        }

	    public int getProduct() {
	    }
    }
    All methods should work in O(1) time.

    Example:
    SlidingWindow window = new SlidingWindow(3);
    window.add(1); // [1]
    window.add(2); // [1, 2]
    window.getProduct(); // 2
    window.add(3); // [1, 2, 3]
    window.getProduct(); // 6
    window.add(4); // [2, 3, 4]
    window.getProduct(); // 24

    Follow-up:
    What if k is a method argument instead of constructor?

    public int getProduct(int k) {
    }

    You can assume that a product will fit into a single 32-bit integer without overflowing.
 */

public class SlidingWindow {
    private LinkedList<Integer> list;
    private int size;
    private int product;
    private int numZero;

    public SlidingWindow(int k) {
        list = new LinkedList<>();
        size = k;
        product = 1;
    }

    public void add(int val) {
        if(size <= 1) {
            return;
        }
        list.add(val);
        if(list.size() > size) {
            int remove = list.poll();
            if(remove == 0) {
                numZero--;
            } else {
                product /= remove;
            }
        }

        if(val == 0) {
            numZero++;
        } else {
            product *= val;
        }
    }

    public int getProduct() {
        if(size == 0 || numZero > 0) return 0;
        return product;
    }
}
