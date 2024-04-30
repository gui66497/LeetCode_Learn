/*31. 下一个排列

中等

整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。

例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。

例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。

必须 原地 修改，只允许使用额外常数空间。

示例 1：

输入：nums = [1,2,3]
输出：[1,3,2]
示例 2：

输入：nums = [3,2,1]
输出：[1,2,3]
示例 3：

输入：nums = [1,1,5]
输出：[1,5,1]

提示：

1 <= nums.length <= 100
0 <= nums[i] <= 100*/

import java.util.Arrays;

class Lesson31_2 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int i = n - 2;
        int j = n - 1;
        //待交换的小数 尽可能靠右
        int k = 0;
        //待交换的大数 尽可能小
        int t = 0;
        while (i >= 0 && j >= 0) {
            if (nums[j] > nums[i]) {
                k = i;
                break;
            }
            i--;
            j--;
        }
        for (int l = n - 1; l > k; l--) {
            if (nums[l] > nums[k]) {
                t = l;
                break;
            }
        }

        //交换
        swap(nums, k, t);

        //交换完之后 将k后面的元素倒转
        if (j == 0) {
            //j==0代表没有更大的了 直接反转整个数组
            reverse(nums, 0);
        } else {
            reverse(nums, k + 1);
        }
    }

    //交换两个元素
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //反转数组
    void reverse(int[] nums, int i) {
        int start = i;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        //下个是4 5 3 1 2 6
//        int[] nums = new int[]{4, 5, 2, 6, 3, 1};
        int[] nums = new int[]{2, 3, 1};
        Lesson31_2 solution = new Lesson31_2();
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}