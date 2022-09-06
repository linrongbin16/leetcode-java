package com.github.linrongbin16.solution3;

public class LongestSubstringWithoutRepeatingCharacters {
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // last[i]表示字符i最后一次出现的下标
        int[] last = new int[128];
        for (int i = 0; i < 128; ++i) {
            last[i] = -1;
        }
        int res = 0;
        // start为最长字串的起始位置
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            // 将s[i]字符转化为整数
            int index = (int) s.charAt(i);
            // 新的起始位置是last[index]和start中较大的那个
            start = Math.max(start, last[index] + 1);
            // i-start+1是当前s[i]字符到start起始位置的长度
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
