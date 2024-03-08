// 283. 移动零
// 简单

// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。

// 示例 1:

// 输入: nums = [0,1,0,3,12]
// 输出: [1,3,12,0,0]
// 示例 2:

// 输入: nums = [0]
// 输出: [0]

// 提示:

// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1

// 进阶：你能尽量减少完成的操作次数吗？

import java.util.Arrays;

class Lesson283 {

    public void moveZeroes(int[] nums) {
        // 遍历，构造index=0，如果当前数不为0，则num[index]=i,index++，最后剩余位置补0
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < n; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        Lesson283 solution = new Lesson283();
        solution.moveZeroes(nums);
        System.out.println("res:" + Arrays.toString(nums));
    }
}