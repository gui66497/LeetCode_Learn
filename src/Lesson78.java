import java.util.ArrayList;
import java.util.List;

// 78. 子集
// 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

// 示例 1：

// 输入：nums = [1,2,3]
// 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 示例 2：

// 输入：nums = [0]
// 输出：[[],[0]]

// 提示：

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同

class Solution78 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    void dfs(int[] nums, int idx, List<Integer> path) {
        if (path.size() > nums.length)
            return;

        res.add(new ArrayList<>(path));
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution78 solution = new Solution78();
        List<List<Integer>> res = solution.subsets(new int[] { 1, 2, 3 });
        System.out.println("res:" + res);
    }
}