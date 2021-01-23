// 67. 二进制求和
// 给你两个二进制字符串，返回它们的和（用二进制表示）。

// 输入为 非空 字符串且只包含数字 1 和 0。

// 示例 1:

// 输入: a = "11", b = "1"
// 输出: "100"
// 示例 2:

// 输入: a = "1010", b = "1011"
// 输出: "10101"

// 提示：

// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。

class Solution67 {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int N = Math.max(lenA, lenB);
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int numA = i >= lenA ? 0 : a.charAt(a.length() - i - 1) - '0';
            int numB = i >= lenB ? 0 : b.charAt(b.length() - i - 1) - '0';
            int sum = carry + numA + numB;
            res.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            res.append(1);
        }
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        Solution67 solution = new Solution67();
        String res1 = solution.addBinary("11", "1");
        System.out.println("res1：" + res1);
    }
}