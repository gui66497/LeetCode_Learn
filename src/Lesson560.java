/*560. 和为 K 的子数组
中等

给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列。

示例 1：

输入：nums = [1,1,1], k = 2
输出：2
示例 2：

输入：nums = [1,2,3], k = 3
输出：2

提示：

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107*/

class Lesson560 {

    //解法1 时间复杂度n*n
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
            sum = 0;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        Lesson560 solution = new Lesson560();
        int res = solution.subarraySum(nums, 2);
        System.out.println(res);
    }
}