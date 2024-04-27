/*75. 颜色分类

中等

提示
给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
必须在不使用库内置的 sort 函数的情况下解决这个问题。

示例 1：

输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
示例 2：

输入：nums = [2,0,1]
输出：[0,1,2]

提示：

n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2

进阶：

你能想出一个仅使用常数空间的一趟扫描算法吗？*/

import java.util.Arrays;

class Lesson75_2 {

    // 单指针 两次遍历
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int temp = nums[ptr];
                nums[ptr] = 0;
                nums[i] = temp;
                ptr++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[ptr];
                nums[ptr] = 1;
                nums[i] = temp;
                ptr++;
            }
        }
    }

    public static void main(String[] args) {
        Lesson75_2 solution = new Lesson75_2();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println("res:" + Arrays.toString(nums));
    }
}