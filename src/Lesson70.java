// 70. 爬楼梯
// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

// 注意：给定 n 是一个正整数。

// 示例 1：

// 输入： 2
// 输出： 2
// 解释： 有两种方法可以爬到楼顶。
// 1.  1 阶 + 1 阶
// 2.  2 阶
// 示例 2：

// 输入： 3
// 输出： 3
// 解释： 有三种方法可以爬到楼顶。
// 1.  1 阶 + 1 阶 + 1 阶
// 2.  1 阶 + 2 阶
// 3.  2 阶 + 1 阶

class Lesson70 {

    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        int[] memos = new int[n + 1];
        if (n == 1) {
            memos[n] = 1;
        } else if (n == 2) {
            memos[n] = 2;
        } else {
            memos[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }
        return memos[n];
    }

    public int climbStairs2(int n) {
        // 动态规划
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Lesson70 solution = new Lesson70();
        int res = solution.climbStairs(4);
        System.out.println("res:" + res);
        int res2 = solution.climbStairs2(4);
        System.out.println("res2:" + res2);
    }
}