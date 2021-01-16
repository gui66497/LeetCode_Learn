// 7. 整数反转
// 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 

// 注意：

// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 

// 示例 1：

// 输入：x = 123
// 输出：321
// 示例 2：

// 输入：x = -123
// 输出：-321
// 示例 3：

// 输入：x = 120
// 输出：21
// 示例 4：

// 输入：x = 0
// 输出：0
 

// 提示：

// -231 <= x <= 231 - 1

class Solution7 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            x /= 10;
            if ((res == Integer.MAX_VALUE / 10 && t > Integer.MAX_VALUE % 10) || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if ((res == Integer.MIN_VALUE / 10 && t < Integer.MIN_VALUE % 10) || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + t;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        int res = solution.reverse(-123);
        System.out.println("res:" + res);
    }
}