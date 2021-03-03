//215. 数组中的第K个最大元素
//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//示例 1:
//
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//示例 2:
//
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//说明:
//
//你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

import java.util.Arrays;
import java.util.PriorityQueue;

class Lesson215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < len - k; i++) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Lesson215 solution = new Lesson215();
        int res = solution.findKthLargest(new int[] { 2, 2, 3, 4, 4 }, 2);
        int res2 = solution.findKthLargest2(new int[] { 2, 2, 3, 4, 4 }, 2);
        System.out.println(res);
        System.out.println(res2);
    }
}