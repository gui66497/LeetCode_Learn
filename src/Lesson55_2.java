// 55. 跳跃游戏
// 给定一个非负整数数组，你最初位于数组的第一个位置。

// 数组中的每个元素代表你在该位置可以跳跃的最大长度。

// 判断你是否能够到达最后一个位置。

// 示例 1:

// 输入: [2,3,1,1,4]
// 输出: true
// 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 示例 2:

// 输入: [3,2,1,0,4]
// 输出: false
// 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

class Solution55_2 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        // 能到达的最远下标
        int maxReach = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxReach >= i) {// 要先判断当前位置能否达到
                maxReach = Math.max(maxReach, nums[i] + i);// 更新最远距离
                if (maxReach >= n - 1) {// 最远距离能达到最后一步，停止寻找，返回true
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 0, 8, 2, 0, 0, 1 };
        Solution55_2 solution = new Solution55_2();
        boolean res = solution.canJump(nums);
        System.out.println(res);
    }
}