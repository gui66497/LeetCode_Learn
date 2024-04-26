/*416. 分割等和子集
中等

给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。

提示：

1 <= nums.length <= 200
1 <= nums[i] <= 100*/

/**
 * Lesson394
 */
public class Lesson416 {
    //挑选一些数字 使得和为总和一半
    public boolean canPartition(int[] nums) {
        //动态规划
        //dp[i][j]=dp[i-1][j] or dp[i-1][j-nums[i]]
        //dp
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        //不是偶数 结果肯定是false
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n][target + 1];

        //第一行 初始化 只有一个数字 所以只有等于target的为true 其它都为false
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        //从第二行开始
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                //不选当前数字
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == target) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }

            }
        }
        return dp[n-1][target];
    }

    public static void main(String[] args) {
        Lesson416 solution = new Lesson416();
        boolean res = solution.canPartition(new int[]{100});
        System.out.println(res);
    }
    
}