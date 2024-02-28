// 128. 最长连续序列
// 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

// 示例 1：

// 输入：nums = [100,4,200,1,3,2]
// 输出：4
// 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
// 示例 2：

// 输入：nums = [0,3,7,2,5,8,4,6,0,1]
// 输出：9
 

// 提示：

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109

import java.util.Set;
import java.util.HashSet;

public class Lesson128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums) {
            set.add(n);
        }
        //记录最长长度
        int longCurr = 0;
        for (int n:nums) {
            if (!set.contains(n-1)) {
                //当前子串长度
                int curr = 0;
                while (set.contains(n)) {
                    curr ++;
                    n ++;
                }
                longCurr = Math.max(curr, longCurr);
            }
        }
        return longCurr;
    }
    public static void main(String[] args) {
        Lesson128 solution = new Lesson128();
        int res = solution.longestConsecutive(new int[] { 100,4,200,1,3,2 });
        System.out.println(res);
    }
}
