import java.util.HashMap;
import java.util.Map;

/*387. 字符串中的第一个唯一字符
简单

给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。

示例 1：

输入: s = "leetcode"
输出: 0
示例 2:

输入: s = "loveleetcode"
输出: 2
示例 3:

输入: s = "aabb"
输出: -1

提示:

1 <= s.length <= 105
s 只包含小写字母*/

class Lesson387 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int val = map.getOrDefault(c, 0);
            map.put(c, val + 1);
        }
        int index = 0;
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Lesson387 solution = new Lesson387();
        int res = solution.firstUniqChar("eee");
        System.out.println("res:" + res);
    }
}