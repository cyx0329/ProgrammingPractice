package com.study.interview.amazon.OA2021;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StorageOptimization {

    public static int storageOptimization(int n, int m, List<Integer> h, List<Integer> v) {
        // WRITE YOUR BRILLIANT CODE HERE
        System.out.println(getMax(n+1, h));
        System.out.println(getMax(m+1, v));
        return getMax(n+1, h) * getMax(m+1, v) * 1;
    }

    private static int getMax(int size, List<Integer> list) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 1; i < size; i++) {
            set.add(i);
        }
        for(int i = 0; i < list.size(); i++) {
            set.remove(list.get(i));
        }
        int set_size = set.size();
        if(set_size == 0) return size;
        int[] array = new int[set_size];
        int count = 0;
        for(Integer element : set) {
            array[count++] = element;
        }
        Arrays.sort(array);
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i] - array[i - 1]);
        }
        return Math.max(max, size - array[array.length - 1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        List<Integer> h = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> v = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = storageOptimization(n, m, h, v);
        System.out.println(res);
    }
}
/*
Test #1:
Input
3
3
2
2
Output
4

Test #2:
Input
2
2
1
2
Output
4

Test #3:
Input
3
2
1 2 3
1 2
Output
12

 */
/*
The local library is considering making their bookshelves more efficient by implementing a new flexible shelf system. The new shelves consist of rearrangeable dividers (both vertically and horizontally), with the smallest blocks being a cube of 1 foot by 1 foot by 1 foot.

Given a shelf configuration, calculate the volume of the largest space in the shelf.

n = number of horizontal dividers

m = number of vertical dividers

h = a list of numbers representing the horizontal dividers that are missing

v = a list of numbers representing the vertical dividers that are missing

Example 1:
Input:
n = 6 m = 6 h = [4] v = [2]

Output: 4
Explanation:
Consider the diagram below. The left image depicts the initial storage unit with all the dividers. The right image depicts the unit after h = [4] and v = [2] dividers are removed. The maximum storage volume for that shelf is therefore 2 x 2 x 1 = 4 cubic feet. The last dimension is always 1, since all shelves are 1 foot deep.



Example 2:
Input:
n = 3 m = 3 h = [2] v = [2]

Output: 4
Explanation:
There are n = m = 3 dividers in each direction. After removing divider [2] from both axes, we have the following.



The largest space size is 2 x 2 x 1 = 4 cubic feet.

Example 3:
Input:
n = 3 m = 2 h = [1, 2, 3] v = [1, 2]

Output: 12
Explanation:
After removing all the separators, the unit will look like the following.



The volume is the size of the overall shelf, which is 3 x 4 x 1 = 12 cubic feet.
 */