// 633. 平方数之和
// 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。

// 示例 1：

// 输入：c = 5
// 输出：true
// 解释：1 * 1 + 2 * 2 = 5
// 示例 2：

// 输入：c = 3
// 输出：false
// 示例 3：

// 输入：c = 4
// 输出：true
// 示例 4：

// 输入：c = 2
// 输出：true
// 示例 5：

// 输入：c = 1
// 输出：true

// 提示：

// 0 <= c <= 231 - 1

class Lesson633 {

    public boolean judgeSquareSum(int c) {
        // 双指针法
        int low = 0;
        int high = (int) Math.sqrt(c);
        while (low <= high) {
            if (low * low + high * high < c) {
                low++;
            } else if (low * low + high * high > c) {
                high--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Lesson633 solution = new Lesson633();
        boolean res = solution.judgeSquareSum(3);
        System.out.println("res:" + res);
    }
}