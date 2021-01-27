import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 77. 组合
// 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

// 示例:

// 输入: n = 4, k = 2
// 输出:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        // 回溯法
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            System.out.println("递归之前 => " + path);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }

    public static void main(String[] args) {
        Solution77 solution = new Solution77();
        List<List<Integer>> res = solution.combine(4, 2);
        System.out.println("res:" + res);
    }
}