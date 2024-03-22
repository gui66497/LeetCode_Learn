// 34. 在排序数组中查找元素的第一个和最后一个位置
// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

// 如果数组中不存在目标值 target，返回 [-1, -1]。

// 进阶：

// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

// 示例 1：

// 输入：nums = [5,7,7,8,8,10], target = 8
// 输出：[3,4]
// 示例 2：

// 输入：nums = [5,7,7,8,8,10], target = 6
// 输出：[-1,-1]
// 示例 3：

// 输入：nums = [], target = 0
// 输出：[-1,-1]

// 提示：

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums 是一个非递减数组
// -109 <= target <= 109

import java.util.Arrays;

class Lesson34_2 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[] { -1, -1 };
        }

        int firstPosition = findFirst(nums, target);
        if (firstPosition < 0 || nums[firstPosition] != target) {
            return new int[]{-1, -1};
        }

        int lastPosition = findLast(nums, target);

        return new int[]{firstPosition, lastPosition};
    }

    int findFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                r = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    int findLast(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >>> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 2 };
        Lesson34_2 solution = new Lesson34_2();
        int[] res = solution.searchRange(nums, 1);
        System.out.println(Arrays.toString(res));
    }
}