import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//47. 全排列 II
//中等
//
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//示例 1：
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
//[1,2,1],
//[2,1,1]]
//示例 2：
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//提示：
//
//1 <= nums.length <= 8
//-10 <= nums[i] <= 10

class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();
        boolean[] used = new boolean[n];
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        backTrack(nums, tempRes, res, used);
        return res;
    }

    void backTrack(int[] nums, List<Integer> tempRes, List<List<Integer>> res, boolean[] used) {
        if (tempRes.size() == nums.length) { // 序列满了，插入res，返回
            res.add(new ArrayList<>(tempRes));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                    continue;
                }
                tempRes.add(nums[i]);
                used[i] = true;
                backTrack(nums, tempRes, res, used);
                tempRes.remove(tempRes.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 2 };
        Solution47 solution = new Solution47();
        List<List<Integer>> res = solution.permuteUnique(nums);
        System.out.println(res);
    }
}