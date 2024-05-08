import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*239. 滑动窗口最大值
困难

给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。

示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
1 [3  -1  -3] 5  3  6  7       3
1  3 [-1  -3  5] 3  6  7       5
1  3  -1 [-3  5  3] 6  7       5
1  3  -1  -3 [5  3  6] 7       6
1  3  -1  -3  5 [3  6  7]      7
示例 2：

输入：nums = [1], k = 1
输出：[1]

提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length*/

class Lesson239 {

    //1朴素方法 时间负责度O(nk) 会超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = l + k - 1;
        int[] res = new int[n - k + 1];
        while (r < n) {
            int max = maxNum(nums, l, r);
            res[l] = max;
            l++;
            r++;
        }

        return res;
    }

    int maxNum(int[] nums, int l, int r) {
        int res = Integer.MIN_VALUE;
        while (l <= r) {
            res = Math.max(res, nums[l]);
            l++;
        }
        return res;
    }

    //2优先队列 时间负责度O(nlogn)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        int[] res = new int[n - k + 1];
        res[0] = queue.peek()[0];
        for (int i = k; i < n; i++) {
            queue.offer(new int[]{nums[i], i});
            //最大的元素如果不属于当前队列 则出队
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[0];
        }
        return res;
    }

    //3单调队列 时间负责度
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            //队列不为空 且队列尾部元素小于当前元素
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            //队列头部元素不在窗口内
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        Lesson239 solution = new Lesson239();
        int[] res = solution.maxSlidingWindow(nums, 3);
        int[] res2 = solution.maxSlidingWindow2(nums, 3);
        int[] res3 = solution.maxSlidingWindow3(nums, 3);
        System.out.println("res:" + Arrays.toString(res));
        System.out.println("res2:" + Arrays.toString(res2));
        System.out.println("res3:" + Arrays.toString(res3));
    }
}