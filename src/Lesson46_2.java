import java.util.ArrayList;
import java.util.List;

//46. 全排列
//已解答
//中等
//相关标签
//相关企业
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//示例 1：
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//示例 2：
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//示例 3：
//
//输入：nums = [1]
//输出：[[1]]
//
//提示：
//
//1 <= nums.length <= 6
//-10 <= nums[i] <= 10
//nums 中的所有整数 互不相同

class Solution46_2 {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();
        boolean[] used = new boolean[n];
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
                tempRes.add(nums[i]);
                used[i] = true;
                backTrack(nums, tempRes, res, used);
                tempRes.remove(tempRes.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        Solution46_2 solution = new Solution46_2();
        List<List<Integer>> res = solution.permute(nums);
        System.out.println(res);
    }
}