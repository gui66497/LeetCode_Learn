import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*15. 三数之和
中等

给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：

输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：

输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。

提示：

3 <= nums.length <= 3000
-105 <= nums[i] <= 105*/

class Lesson15_2 {
    //数组遍历 先升序排列 然后双指针查找
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //升序排列
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = n - 1;
            while (L < R) {
                int sum = num + nums[L] + nums[R];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    res.add(list);
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lesson15_2 solution = new Lesson15_2();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums2 = new int[]{-2, 0, 0, 2, 2};
        List<List<Integer>>  res = solution.threeSum(nums2);
        System.out.println(res);
    }
}
