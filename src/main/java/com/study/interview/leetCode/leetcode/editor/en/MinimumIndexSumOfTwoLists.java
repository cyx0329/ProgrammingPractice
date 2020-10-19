//
//Suppose Andy and Doris want to choose a restaurant for dinner, and they both h
//ave a list of favorite restaurants represented by strings. 
// 
// 
//You need to help them find out their common interest with the least list index
// sum. If there is a choice tie between answers, output all of them with no order
// requirement. You could assume there always exists an answer.
// 
//
//
// Example 1: 
// 
//Input:
//["Shogun", "Tapioca Express", "Burger King", "KFC"]
//["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//Output: ["Shogun"]
//Explanation: The only restaurant they both like is "Shogun".
// 
// 
//
// Example 2: 
// 
//Input:
//["Shogun", "Tapioca Express", "Burger King", "KFC"]
//["KFC", "Shogun", "Burger King"]
//Output: ["Shogun"]
//Explanation: The restaurant they both like and have the least index sum is "Sh
//ogun" with index sum 1 (0+1).
// 
// 
//
//
// Note: 
// 
// The length of both lists will be in the range of [1, 1000]. 
// The length of strings in both lists will be in the range of [1, 30]. 
// The index is starting from 0 to the list length minus 1. 
// No duplicates in both lists. 
// 
// Related Topics Hash Table


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        Solution solution = new MinimumIndexSumOfTwoLists().new Solution();
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Shogun","Burger King"};
        solution.findRestaurant(list1, list2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> map = new HashMap<>();
            Map<Integer, String> countMap = new HashMap<>();
            String[] result = new String[1];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }
            for (int j = 0; j < list2.length; j++) {
                if (map.containsKey(list2[j])) {
                    //if (min > map.get(list2[j]) + j) {
                     //   result[0] = list2[j];
                     //   min = map.get(list2[j]) + j;
                    //}
                    min = Math.min(min, map.get(list2[j]) + j);
                    countMap.put(min, list2[j]);
                }
            }
            result[0] = countMap.get(min);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}