
/*316. 去除重复字母
中等

提示
给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

示例 1：

输入：s = "bcabc"
输出："abc"
示例 2：

输入：s = "cbacdcbc"
输出："acdb"

提示：

1 <= s.length <= 104
s 由小写英文字母组成*/

import java.util.Stack;

class Lesson316 {

    public String removeDuplicateLetters(String s) {

        Stack<Character> stk = new Stack<>();

        //记录每个字符的出现次数
        int[] countArr = new int[128];
        for (char c : s.toCharArray()) {
            countArr[c]++;
        }

        boolean[] inStack = new boolean[128];
        for (char c : s.toCharArray()) {
            // 每遍历过一个字符，都将对应的计数减一
            countArr[c]--;

            if (inStack[c]) continue;

            while (!stk.isEmpty() && c < stk.peek() && countArr[stk.peek()] > 0) {
                char tmp = stk.pop();
                inStack[tmp] = false;
            }

            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Lesson316 solution = new Lesson316();
        String res = solution.removeDuplicateLetters("bcabc");
        System.out.println("res:" + res);
    }
}