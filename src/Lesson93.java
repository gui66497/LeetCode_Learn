import java.util.ArrayList;
import java.util.List;

// 93. 复原 IP 地址
// 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。

// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。

// 示例 1：

// 输入：s = "25525511135"
// 输出：["255.255.11.135","255.255.111.35"]
// 示例 2：

// 输入：s = "0000"
// 输出：["0.0.0.0"]
// 示例 3：

// 输入：s = "1111"
// 输出：["1.1.1.1"]
// 示例 4：

// 输入：s = "010010"
// 输出：["0.10.0.10","0.100.1.0"]
// 示例 5：

// 输入：s = "101023"
// 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

// 提示：

// 0 <= s.length <= 3000
// s 仅由数字组成

class Solution93 {

    List<String> res = new ArrayList<>();

    public boolean isValidIp(String str) {
        int len = str.length();
        if (len > 1 && str.charAt(0) == '0') {
            return false;
        }
        return Integer.parseInt(str) <= 255;
    }

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, new ArrayList<>());
        return res;
    }

    public boolean dfs(String s, int begin, int len, List<String> path) {
        if (path.size() == 4) {
            if (begin == s.length()) {
                res.add(String.join(".", path));
                return true;
            } else {
                return false;
            }
        }
        for (int i = 1; i < 4; i++) {
            if ((begin + i) > s.length()) {
                continue;
            }
            String ipStr = s.substring(begin, begin + i);
            if (!isValidIp(ipStr)) {
                continue;
            }
            path.add(ipStr);
            dfs(s, begin + i, i, path);
            path.remove(path.size() - 1);

        }
        return false;
    }

    public static void main(String[] args) {
        Solution93 solution = new Solution93();
        List<String> res = solution.restoreIpAddresses("25525511135");
        System.out.println("res:" + res);
    }
}