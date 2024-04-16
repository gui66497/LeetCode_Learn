/*5. 最长回文子串
中等

给你一个字符串 s，找到 s 中最长的回文子串。

如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"

提示：

1 <= s.length <= 1000
s 仅由数字和英文字母组成*/

class Lesson5_2 {
    public String longestPalindrome(String s) {
        //dp[i,j]=dp[i+1,j-1] && s[i]==s[j]
        //dp[i][i]=true
        //求是回文的中j-i最大的
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int maxLen = 0;
        int l = 0;
        int r = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        l = i;
                        r = j;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }

    public static void main(String[] args) {
        String str = "cbbd";
        Lesson5_2 solution = new Lesson5_2();
        String res = solution.longestPalindrome(str);
        System.out.println("res:" + res);
    }

}
