//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array. 
//
// Note: 
//
// 
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. 
// You may assume that nums1 has enough space (size that is equal to m + n) to h
//old additional elements from nums2. 
// 
//
// Example: 
//
// 
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
// 
//
// 
// Constraints: 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics Array Two Pointers 
// 👍 2715 👎 4529

  
package com.study.interview.leetCode.leetcode.editor.en;
  public class MergeSortedArray{
      public static void main(String[] args) {
           Solution solution = new MergeSortedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int len = m+n-1;
        while(i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[len] = nums2[j];
                j--;
            } else {
                nums1[len] = nums1[i];
                i--;
            }
            len--;
        }
        if(j < 0) return;
        if(i < 0) {
            while(len >= 0) {
                nums1[len] = nums2[j];
                j--;
                len--;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }