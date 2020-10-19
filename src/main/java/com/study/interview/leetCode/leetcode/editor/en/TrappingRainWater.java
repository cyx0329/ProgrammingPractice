//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it is able to trap after raining. 
//
// 
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In 
//this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos
// for contributing this image! 
//
// Example: 
//
// 
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6 
// Related Topics Array Two Pointers Stack

package com.study.interview.leetCode.leetcode.editor.en;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int out = solution.trap(height);
        System.out.println(out);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            //Approach 4: Using 2 pointer
            /*
            if (height == null || height.length == 0) {
                return 0;
            }
            int ans = 0;
            int left = 0, right = height.length - 1;
            int left_max = 0, right_max = 0;
            while (left < right) {
                if (height[left] < height[right]) {
                    if (height[left] >= left_max) {
                        left_max = height[left];
                    } else {
                        ans += left_max - height[left];
                    }
                    left++;
                } else {
                    if (height[right] >= right_max) {
                        right_max = height[right];
                    } else {
                        ans += right_max - height[right];
                    }
                    right--;
                }
            }
            return ans;
            */
            if(height == null || height.length == 0) return 0;
            int res = 0;
            int n = height.length;
            int[] leftMax = new int[n];
            int[] rightMax = new int[n];

            leftMax[0] = height[0];
            for(int i = 1; i < n; i++) {
                leftMax[i] = Math.max(height[i], leftMax[i-1]);
            }

            rightMax[n-1] = height[n-1];
            for(int i = n-2; i >= 0; i--) {
                rightMax[i] = Math.max(height[i], rightMax[i+1]);
            }

            for(int i = 0; i < n; i++) {
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}