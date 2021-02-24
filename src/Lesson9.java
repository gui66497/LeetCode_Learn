import java.util.Deque;
import java.util.LinkedList;

// 9. 回文数
// 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

// 示例 1:

// 输入: 121
// 输出: true
// 示例 2:

// 输入: -121
// 输出: false
// 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 示例 3:

// 输入: 10
// 输出: false
// 解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 进阶:

// 你能不将整数转为字符串来解决这个问题吗？

class Solution9 {
    // 转换成字符串 用栈解决
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        String str = String.valueOf(x);
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return str.equals(sb.toString());
    }

    public boolean isPalindrome2(int x) {
        // 思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int result = 0;
        while (num != 0) {
            int n = num % 10;
            result = result * 10 + n;
            num = num / 10;
        }
        return x == result;
    }

    public static void main(String[] args) {
        int num = 1223;
        int x = num;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        System.out.println("revertedNumber:" + revertedNumber);
        Solution9 solution = new Solution9();
        boolean res = solution.isPalindrome(num);
        System.out.println("res:" + res);
        boolean res2 = solution.isPalindrome2(num);
        System.out.println("res2:" + res2);
        boolean res3 = solution.isPalindrome3(num);
        System.out.println("res3:" + res3);
    }
}