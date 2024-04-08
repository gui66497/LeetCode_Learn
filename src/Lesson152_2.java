/*152. 乘积最大子数组

中等

给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

测试用例的答案是一个 32-位 整数。

示例 1:

输入: nums = [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: nums = [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

提示:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数*/

class Lesson152_2 {
    public int maxProduct(int[] nums) {
        //因为是乘法 所以可能由最小变成最大（负负得正），所以要同时维护最小值和最大值
        //dp[i] = Math.max(dm[i - 1] * nums[i], Math.max(dp[i - 1] * nums[i], nums[i]));
        int n = nums.length;
        int dp[] = new int[n];
        int dm[] = new int[n];

        dp[0] = nums[0];
        dm[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dm[i - 1] * nums[i], Math.max(dp[i - 1] * nums[i], nums[i]));
            dm[i] = Math.min(dm[i - 1] * nums[i], Math.min(dp[i - 1] * nums[i], nums[i]));
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        Lesson152_2 solution = new Lesson152_2();
        int res = solution.maxProduct(new int[]{-2});
        System.out.println(res);
    }
}
