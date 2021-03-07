import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 347. 前 K 个高频元素
// 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

// 示例 1:

// 输入: nums = [1,1,1,2,2,3], k = 2
// 输出: [1,2]
// 示例 2:

// 输入: nums = [1], k = 1
// 输出: [1]

// 提示：

// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
// 你可以按任意顺序返回答案。

class Lesson347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // 默认小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> map.get(a).compareTo(map.get(b)));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry.getKey());
            } else if (entry.getValue() > map.get(queue.peek())) {
                queue.poll();
                queue.offer(entry.getKey());
            }
        }
        int[] res = new int[k];
        int size = 0;
        while (!queue.isEmpty()) {
            res[size++] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        Lesson347 solution = new Lesson347();
        int[] res = solution.topKFrequent(new int[] { 3, 0, 1, 0 }, 1);
        System.out.println(Arrays.toString(res));
    }
}