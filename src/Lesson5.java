// 5. 最长回文子串
// 给你一个字符串 s，找到 s 中最长的回文子串。

 

// 示例 1：

// 输入：s = "babad"
// 输出："bab"
// 解释："aba" 同样是符合题意的答案。
// 示例 2：

// 输入：s = "cbbd"
// 输出："bb"
// 示例 3：

// 输入：s = "a"
// 输出："a"
// 示例 4：

// 输入：s = "ac"
// 输出："a"
 

// 提示：

// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成

class Lesson5 {
    public String longestPalindrome(String s) {
        // 暴力法
        if (s.length() == 1) {
            return s;
        }

        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }

        char[] allChars = s.toCharArray();
        int right = s.length() - 1;
        int maxLen = 0;
        int recordL = 0;
        int recordR = right;
        for (int i = 0; i < right; i++) {
            for (int j = right; j > i; j--) {
                if (isHuiWen(allChars, i, j)) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        recordL = i;
                        recordR = j;
                    }
                }
            }
        }
        if (maxLen == 0) {
            return s.substring(0, 1);
        }

        return s.substring(recordL, recordR + 1);
    }

    // 判断是否是回文
    boolean isHuiWen(char[] chars, int left, int right) {
        int l = left;
        int r = right;
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public String longestPalindrome2(String s) {
        // 动态规划
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int begin = 0;
        int maxLen = 1;
        boolean dp[][] = new boolean[n][n];
        // 从上到下一列一列填
        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) != s.charAt(r)) {
                    dp[l][r] = false;
                } else {
                    if (r - l < 3) {
                        // 长度不超过3 且两端已相等 必为true
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                }
                if (dp[l][r] && (r - l + 1) > maxLen) {
                    maxLen = r - l + 1;
                    begin = l;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String str = "abcbb";
        Lesson5 solution = new Lesson5();
        String res = solution.longestPalindrome(str);
        System.out.println("res:" + res);
        String res2 = solution.longestPalindrome2(str);
        System.out.println("res:" + res2);
    }

}
