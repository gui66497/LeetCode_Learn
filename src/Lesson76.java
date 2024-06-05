/*76. 最小覆盖子串
困难

给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。

示例 1：

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
示例 2：

输入：s = "a", t = "a"
输出："a"
解释：整个字符串 s 是最小覆盖子串。
示例 3:

输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。

提示：

m == s.length
n == t.length
1 <= m, n <= 105
s 和 t 由英文字母组成


进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？*/

class Lesson76 {

    public String minWindow(String s, String t) {
        // 双指针
        int m = s.length();
        int ansLeft = -1;
        int ansRight = m;

        int left = 0;
        int[] arrS = new int[128];
        int[] arrT = new int[128];
        for (char temp : t.toCharArray()) {
            arrT[temp]++;
        }

        for (int right = 0; right < m; right++) {
            arrS[s.charAt(right)]++;

            while (isBao(arrS, arrT)) {
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                arrS[s.charAt(left)]--;
                left++;
            }
        }
        if (ansLeft == -1) {
            return "";
        } else {
            return s.substring(ansLeft, ansRight + 1);
        }
    }

    boolean isBao(int[] arrS, int[] arrT) {
        for (int i = 'a'; i <= 'z'; i++) {
            if (arrS[i] < arrT[i]) {
                return false;
            }
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            if (arrS[i] < arrT[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Lesson76 solution = new Lesson76();
        String res = solution.minWindow(s, t);
        System.out.println("res:" + res);
    }
}