package com.me.leetCode.four;

import java.util.Arrays;

/**
 * @Autor syl
 * @Date 2019/1/29 15:31
 **/
public class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1length = nums1.length;
        int nums2length = nums2.length;
        int[] newnums = Arrays.copyOf(nums1, nums1length + nums2length);//数组扩容
        System.arraycopy(nums2, 0, newnums, nums1length, nums2length);
        Arrays.sort(newnums);
        if (newnums.length % 2 == 1) {//奇数，取中间
            return newnums[newnums.length / 2];
        }
        double num1 = newnums[newnums.length / 2 - 1];
        double num2 = newnums[newnums.length / 2];
        return (num1 + num2) / 2;
    }

    public static double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
