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

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int res = nums.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public int searchInsert2(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 5, 7 };
        Solution35 solution = new Solution35();
        int res = solution.searchInsert2(nums, 8);
        System.out.println("res:" + res);
    }
}