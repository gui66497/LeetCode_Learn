import java.util.ArrayList;
import java.util.List;

//22. 括号生成
//已解答
//中等

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//示例 1：
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//示例 2：
//
//输入：n = 1
//输出：["()"]
//
//
//提示：
//
//1 <= n <= 8

class Lesson22_2 {
    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        dfs(n, n, n, new StringBuilder(), resList);
        return resList;
    }

    void dfs(int n, int left, int right, StringBuilder sb, List<String> resList) {
        if (sb.length() == 2 * n) {
            resList.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append("(");
            dfs(n, left - 1, right, sb, resList);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(")");
            dfs(n, left, right - 1, sb, resList);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        Lesson22_2 solution = new Lesson22_2();
        List<String> res = solution.generateParenthesis(3);
        System.out.println(res);
    }
}