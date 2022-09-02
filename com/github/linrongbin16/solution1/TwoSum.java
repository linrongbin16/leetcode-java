package com.github.linrongbin16.solution1;

import java.util.Objects;
import java.util.stream.Stream;

public class TwoSum {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] n1 = Stream.of(2, 7, 11, 15).mapToInt(a -> a).toArray();
        int[] r1 = s.twoSum(n1, 9);
        printInts(r1, "r1");

        int[] n2 = Stream.of(3, 2, 4).mapToInt(a -> a).toArray();
        int[] r2 = s.twoSum(n2, 6);
        printInts(r2, "r2");
    }

    static void printInts(int[] result, String msg) {
        if (Objects.nonNull(msg) && msg.strip().length() > 0) {
            System.out.println(String.format("%s: ", msg));
        }
        if (Objects.isNull(result)) {
            System.out.println("null");
        } else {
            for (int i = 0; i < result.length; ++i) {
                System.out.print(String.format("%d ", result[i]));
            }
            System.out.println();
        }
    }

}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i)
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target)
                    return Stream.of(i, j).mapToInt(a -> a).toArray();
            }
        return null;
    }
}