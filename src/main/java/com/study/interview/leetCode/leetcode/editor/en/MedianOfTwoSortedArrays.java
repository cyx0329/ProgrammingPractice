//There are two sorted arrays nums1 and nums2 of size m and n respectively. 
//
// Find the median of the two sorted arrays. The overall run time complexity sho
//uld be O(log (m+n)). 
//
// You may assume nums1 and nums2 cannot be both empty. 
//
// Example 1: 
//
// 
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
// 
//
// Example 2: 
//
// 
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
// 
// Related Topics Array Binary Search Divide and Conquer


package com.study.interview.leetCode.leetcode.editor.en;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if(m > n) return findMedianSortedArrays(nums2, nums1);
            //Why n ≥ m?
            // Because I have to make sure j is non-negative since 0 ≤ i ≤ m and j = (m + n + 1)/2 - i.
            // If n < m, then j may be negative, that will lead to wrong result.
            int halfLen = (m+n+1)/2;
            int left = 0;
            int right = m;
            while(left <= right) {
                int i = left + (right-left)/2;
                int j = halfLen - i;
                //(j = 0 or i = m or B[j−1]≤A[i]) and
                //(i = 0 or j = n or A[i−1]≤B[j])
                //Means ii is perfect, we can stop searching.
                //j > 0 and i < m and B[j−1]>A[i]
                //Means ii is too small, we must increase it.
                //i > 0 and j < n and A[i−1]>B[j]
                //Means ii is too big, we must decrease it.
                //i<m ⟹ j>0 and i>0 ⟹ j<n. Because:
                //m≤n,i<m ⟹ j = (m+n+1)/2 -i > (m+n+1)/2 - m >= (2m+1)/2 >= 0
                //m≤n,i<0 ⟹ j = (m+n+1)/2 -i < (m+n+1)/2 <= (2n+1)/2 <= n
                if(i < right && nums2[j-1] > nums1[i]) {
                    left = i+1;
                } else if(i > left && nums1[i-1] > nums2[j]) {
                    right = i-1;
                } else {
                    int maxLeft = 0;
                    if(i == 0) maxLeft = nums2[j-1];
                    else if(j == 0) maxLeft = nums1[i-1];
                    else maxLeft = Math.max(nums1[i-1], nums2[j-1]);

                    if ( (m + n) % 2 == 1 ) { return maxLeft; }

                    int minRight = 0;
                    if (i == m) minRight = nums2[j];
                    else if (j == n) minRight = nums1[i];
                    else minRight = Math.min(nums1[i], nums2[j]);

                    return (maxLeft+ minRight) / 2.0;
                }

            }
            return 0.0;
            //O(log(min(m,n)))
            //At first, the searching range is [0, m].
            // And the length of this searching range will be reduced by half after each loop.
            // So, we only need log(m) loops. Since we do constant operations in each loop,
            // so the time complexity is O(log(m)).
            // Since m≤n, so the time complexity is O(log(min(m,n))).
            //
            //O(1).

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}