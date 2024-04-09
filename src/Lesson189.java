import java.util.Arrays;

/*189. 轮转数组
中等

给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

示例 1:

输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释:
向右轮转 1 步: [99,-1,-100,3]
向右轮转 2 步: [3,99,-1,-100]

提示：

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

进阶：

尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？*/

class Lesson189 {

    //解法1 使用额外的数组
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int s = k % n;
        int[] res = new int[n];
        //移动1步 0变成1
        for (int i = 0; i < n; i++) {
            int nowIndex = (i + s) % n;
            res[nowIndex] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, n);
    }

    //数组翻转
    //首先对整个数组实行翻转，这样子原数组中需要翻转的子数组，就会跑到数组最前面。
    //这时候，从 kkk 处分隔数组，左右两数组，各自进行翻转即可。
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int s = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, s - 1);
        reverse(nums, s, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Lesson189 solution = new Lesson189();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate2(nums, 3);
        System.out.println("res:" + Arrays.toString(nums));
    }
}