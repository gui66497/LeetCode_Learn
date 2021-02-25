import java.util.ArrayList;
import java.util.List;

// 216. 组合总和 III
// 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

// 说明：

// 所有数字都是正整数。
// 解集不能包含重复的组合。 
// 示例 1:

// 输入: k = 3, n = 7
// 输出: [[1,2,4]]
// 示例 2:

// 输入: k = 3, n = 9
// 输出: [[1,2,6], [1,3,5], [2,3,4]]

class Lesson216 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1, new ArrayList<>());
        return res;
    }

    public void dfs(int k, int n, int start, List<Integer> path) {
        int sum = 0;
        for (Integer num : path) {
            sum += num;
        }
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
                return;
            } else {
                return;
            }
        }
        for (int i = start; i < 10; i++) {
            path.add(i);
            dfs(k, n, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lesson216 solution = new Lesson216();
        List<List<Integer>> res = solution.combinationSum3(3, 7);
        System.out.println("res:" + res);
    }
}