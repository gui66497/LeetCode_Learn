
// 43. 字符串相乘
// 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

// 示例 1:

// 输入: num1 = "2", num2 = "3"
// 输出: "6"
// 示例 2:

// 输入: num1 = "123", num2 = "456"
// 输出: "56088"
// 说明：

// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 竖式乘法 每行结果通过字符串相加得到
        int m = num1.length();
        int n = num2.length();
        String ans = "0";
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int add = 0;
            // 补0
            for (int j = n - 1; j > i; j--) {
                sb.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int res = (x * y + add) % 10;
                sb.append(res);
                add = (x * y + add) / 10;
            }
            if (add != 0) {
                sb.append(add % 10);
            }
            ans = addStrings(ans, sb.reverse().toString());
        }
        return ans;
    }

    // 字符串相加
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int a = num1.length() - 1;
        int b = num2.length() - 1;
        int add = 0;
        while (a >= 0 || b >= 0 || add > 0) {
            int n1 = a >= 0 ? num1.charAt(a) - '0' : 0;
            int n2 = b >= 0 ? num2.charAt(b) - '0' : 0;
            int res = (n1 + n2 + add) % 10;
            add = (n1 + n2 + add) / 10;
            sb.append(res);
            a--;
            b--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution43 solution = new Solution43();
        String res = solution.multiply("9", "9");
        System.out.println(res);
    }
}