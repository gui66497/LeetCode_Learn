import java.util.ArrayList;
import java.util.List;

// 46. 全排列
// 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

// 示例:

// 输入: [1,2,3]
// 输出:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        backTrack(resList, res, nums);
        return resList;
    }

    void backTrack(List<List<Integer>> resList, List<Integer> res, int[] nums) {
        if (res.size() == nums.length) {
            resList.add(new ArrayList<>(res));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!res.contains(nums[i])){
                    res.add(nums[i]);
                    backTrack(resList, res, nums);
                    res.remove(res.size() - 1);
                }
                
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        Solution46 solution = new Solution46();
        List<List<Integer>> res = solution.permute(nums);
        System.out.println(res);
    }
}