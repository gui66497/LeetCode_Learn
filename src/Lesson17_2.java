import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 17. 电话号码的字母组合

// 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。

// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

// 示例:

// 输入："23"
// 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].;
// 说明:
// 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

class Lesson17_2 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() < 1) {
            return new ArrayList<>();
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        StringBuilder sb = new StringBuilder();
        backTrack(digits, phoneMap, 0, combinations, sb);
        return combinations;
    }

    void backTrack(String digits, Map<Character, String> phoneMap, int index, List<String> combinations, StringBuilder sb) {
        if (index == digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        Character c = digits.charAt(index);
        String s = phoneMap.get(c);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backTrack(digits, phoneMap, index + 1, combinations, sb);
            sb.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        Lesson17_2 solution = new Lesson17_2();
        List<String> res = solution.letterCombinations("23");
        System.out.println(res);
    }
}
