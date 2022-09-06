package com.github.linrongbin16.solution4;

public class MediaOfTwoSortedArrays {
}


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int left = (n1 + n2 + 1) / 2;
        int right = (n1 + n2 + 2) / 2;
        return (double) (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length)
            return nums2[j + k - 1];
        if (j >= nums2.length)
            return nums1[i + k - 1];
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int mid1 = i + k / 2 - 1;
        int mid2 = j + k / 2 - 1;
        int val1 = (mid1 < nums1.length) ? nums1[mid1] : Integer.MAX_VALUE;
        int val2 = (mid2 < nums2.length) ? nums2[mid2] : Integer.MAX_VALUE;
        if (val1 < val2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}