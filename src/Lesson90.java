import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90. 子集 II
//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。
//
//示例:
//
//输入: [1,2,2]
//输出:
//[
//[2],
//[1],
//[1,2,2],
//[2,2],
//[1,2],
//[]
//]

class Solution90 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);
        return res;
    }

    void dfs(int[] nums, int idx, List<Integer> path) {
        if (path.size() > nums.length)
            return;

        res.add(new ArrayList<>(path));
        for (int i = idx; i < nums.length; i++) {
            // 同层重复，跳过
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution90 solution = new Solution90();
        List<List<Integer>> res = solution.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println("res:" + res);
    }
}