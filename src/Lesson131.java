/*131. 分割回文串
中等

给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
回文串
。返回 s 所有可能的分割方案。

示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]

提示：

1 <= s.length <= 16
s 仅由小写英文字母组成*/

import java.util.ArrayList;
import java.util.List;

public class Lesson131 {

    int len;

    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        len = s.length();
        dfs(chars, 0, path, res);
        return res;
    }

    void dfs(char[] chars, int index, List<String> path, List<List<String>> res) {
        if (index >= len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            if (!isHui(chars, index, i)) {
                continue;
            } else {
                path.add(new String(chars, index, i - index + 1));
            }
            dfs(chars, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public boolean isHui(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Lesson131 solution = new Lesson131();
        List<List<String>> res = solution.partition("aab");
        System.out.println(res);
    }
}
