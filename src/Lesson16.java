import java.util.Arrays;

// 16. 最接近的三数之和
// 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

// 示例：

// 输入：nums = [-1,2,1,-4], target = 1
// 输出：2
// 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

// 提示：

// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        // 先将数组排序 然后使用双指针法
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - res) > Math.abs(target - temp)) {
                    res = temp;
                }
                if (temp > target) {
                    end--;
                } else if (temp < target) {
                    start++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -1, 2, 1, -4 };
        Solution16 solution = new Solution16();
        int res = solution.threeSumClosest(nums, 1);
        System.out.println(res);
    }
}