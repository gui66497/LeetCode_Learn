// 415. 字符串相加
// 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

// 提示：

// num1 和num2 的长度都小于 5100
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式

class Solution415 {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int a = num1.length() - 1;
        int b = num2.length() - 1;
        int add = 0;
        while (a >= 0 || b >= 0 || add != 0) {
            int n1 = a >= 0 ? num1.charAt(a) - '0' : 0;
            int n2 = b >= 0 ? num2.charAt(b) - '0' : 0;
            int sum = n1 + n2 + add;
            res.append(sum % 10);
            add = sum / 10;
            a--;
            b--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution415 solution = new Solution415();
        String res = solution.addStrings("99", "1");
        System.out.println(res);
    }
}