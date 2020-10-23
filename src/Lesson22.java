import java.util.ArrayList;
import java.util.List;
// 22. 括号生成
// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

// 示例：

// 输入：n = 3
// 输出：[
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//      ]

class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        backTrack(resList, res, 0, 0, n);
        return resList;
    }

    void backTrack(List<String> resList, StringBuilder res, int open, int close, int max) {
        if (res.length() == max * 2) {
            resList.add(res.toString());
        } else {
            if (open < max) {
                res.append("(");
                backTrack(resList, res, open + 1, close, max);
                res.deleteCharAt(res.length() - 1);
            }
            if (close < open) {
                res.append(")");
                backTrack(resList, res, open, close + 1, max);
                res.deleteCharAt(res.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        List<String> res = solution.generateParenthesis(3);
        System.out.println(res);
    }
}