import java.util.Arrays;

// 287. 寻找重复数
// 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。

// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。

// 示例 1：

// 输入：nums = [1,3,4,2,2]
// 输出：2
// 示例 2：

// 输入：nums = [3,1,3,4,2]
// 输出：3
// 示例 3：

// 输入：nums = [1,1]
// 输出：1
// 示例 4：

// 输入：nums = [1,1,2]
// 输出：1

// 提示：

// 2 <= n <= 3 * 104
// nums.length == n + 1
// 1 <= nums[i] <= n
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次

// 进阶：

// 如何证明 nums 中至少存在一个重复的数字?
// 你可以在不修改数组 nums 的情况下解决这个问题吗？
// 你可以只用常量级 O(1) 的额外空间解决这个问题吗？
// 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？

class Lesson287 {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        Lesson287 solution = new Lesson287();
        int res = solution.findDuplicate(nums);
        System.out.println("res:" + res);
    }
}