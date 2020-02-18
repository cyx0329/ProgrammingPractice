//In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the
// i-th domino. (A domino is a tile with two numbers from 1 to 6 - one on each hal
//f of the tile.) 
//
// We may rotate the i-th domino, so that A[i] and B[i] swap values. 
//
// Return the minimum number of rotations so that all the values in A are the sa
//me, or all the values in B are the same. 
//
// If it cannot be done, return -1. 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
//Output: 2
//Explanation: 
//The first figure represents the dominoes as given by A and B: before we do any
// rotations.
//If we rotate the second and fourth dominoes, we can make every value in the to
//p row equal to 2, as indicated by the second figure.
// 
//
// Example 2: 
//
// 
//Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
//Output: -1
//Explanation: 
//In this case, it is not possible to rotate the dominoes to make one row of val
//ues equal.
// 
//
// 
//
// Note: 
//
// 
// 1 <= A[i], B[i] <= 6 
// 2 <= A.length == B.length <= 20000 
// 
// Related Topics Array Greedy


package com.study.interview.leetCode.leetcode.editor.en;

public class MinimumDominoRotationsForEqualRow {
    public static void main(String[] args) {
        Solution solution = new MinimumDominoRotationsForEqualRow().new Solution();
        int[] A = new int[]{2,1,2,4,2,2};
        int[] B = new int[]{5,2,6,2,3,2};
        int rotation = solution.minDominoRotations(A, B);
        System.out.println(rotation);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDominoRotations(int[] A, int[] B) {
            int rotation = canRotaionToEqual(A, B, A[0]);
            if(rotation != -1 || A[0] == B[0]) {
                return rotation;
            } else{
                return canRotaionToEqual(B, A, B[0]);
            }

        }

        public int canRotaionToEqual(int[] A, int[] B, int element) {
            int rotationA = 0, rotationB = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] != element && B[i] != element) {
                    return -1;
                } else if(A[i] != element){
                    rotationA++;
                } else if(B[i] != element) {
                    rotationB++;
                }
            }
            return Math.min(rotationA, rotationB);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}