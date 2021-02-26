import java.util.HashMap;
import java.util.Map;

// 169. 多数元素
// 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。


// 示例 1：

// 输入：[3,2,3]
// 输出：3
// 示例 2：

// 输入：[2,2,1,1,1,2,2]
// 输出：2
 
// 进阶：

// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

class Lesson169 {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Integer times = map.get(nums[i]);
            if (times == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], times + 1);
                if ((times + 1) > max) {
                    maxNum = nums[i];
                    max = times + 1;
                }
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        Lesson169 solution = new Lesson169();
        int res = solution.majorityElement(new int[] { 3, 2, 3 });
        System.out.println("res:" + res);
    }
}