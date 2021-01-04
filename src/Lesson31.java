// 31. 下一个排列
// 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

// 必须 原地 修改，只允许使用额外常数空间。

// 示例 1：

// 输入：nums = [1,2,3]
// 输出：[1,3,2]
// 示例 2：

// 输入：nums = [3,2,1]
// 输出：[1,2,3]
// 示例 3：

// 输入：nums = [1,1,5]
// 输出：[1,5,1]
// 示例 4：

// 输入：nums = [1]
// 输出：[1]

// 提示：

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100

class Solution31 {
    public void nextPermutation(int[] nums) {
        // 首先从后往前找到首个上升
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 从后向前找到首个比前面的小值大一点的
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换两者
            swap(nums, i, j);
        }
        // 反转数组
        reverse(nums, i + 1);
    }

    // 交换数组中的两个元素
    public void swap(int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }

    public void reverse(int[] nums, int start) {
        // 通过上面的swap来实现翻转
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution31 solution = new Solution31();
        int[] nums = new int[] { 1, 2, 3 };
        solution.nextPermutation(nums);
        System.out.println(nums);
    }
}