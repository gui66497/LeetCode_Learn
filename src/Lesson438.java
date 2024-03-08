// 438. 找到字符串中所有字母异位词
// 中等

// 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

// 示例 1:

// 输入: s = "cbaebabacd", p = "abc"
// 输出: [0,6]
// 解释:
// 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
// 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//  示例 2:

// 输入: s = "abab", p = "ab"
// 输出: [0,1,2]
// 解释:
// 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
// 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
// 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。

// 提示:

// 1 <= s.length, p.length <= 3 * 104
// s 和 p 仅包含小写字母

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {
        // 滑动窗口
        // 固定长度的窗口，维护字母出现频次
        int n = s.length();
        int pLen = p.length();
        if (pLen > n) {
            return new ArrayList<>();
        }
        
        int[] pArr = new int[26];
        int[] sArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
            sArr[s.charAt(i) - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        if (Arrays.equals(pArr, sArr)) {
            res.add(0);
        }

        
        for (int i = 0; i < n; i++) {
            if (i + pLen >= n) {
                break;
            }
            sArr[s.charAt(i) - 'a']--;
            sArr[s.charAt(i + pLen) - 'a']++;

            if (Arrays.equals(pArr, sArr)) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaa";
        String p = "aaaaaaaaaaaaa";
        Solution438 solution = new Solution438();
        List<Integer> res = solution.findAnagrams(s, p);
        System.out.println("res:" + res);
    }
}