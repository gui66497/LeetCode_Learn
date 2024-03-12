// 35. 搜索插入位置
// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

// 你可以假设数组中无重复元素。

// 示例 1:

// 输入: [1,3,5,6], 5
// 输出: 2
// 示例 2:

// 输入: [1,3,5,6], 2
// 输出: 1
// 示例 3:

// 输入: [1,3,5,6], 7
// 输出: 4
// 示例 4:

// 输入: [1,3,5,6], 0
// 输出: 0

class Solution35_2 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        int ans = nums.length;
        while (l <= r) {
            mid = ((r - l) >> 1) + l;
            if (target <= nums[mid]) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 5, 6 };
        Solution35_2 solution = new Solution35_2();
        int res = solution.searchInsert(nums, 2);
        System.out.println("res:" + res);
    }
}