// 394. 字符串解码

// 给定一个经过编码的字符串，返回它解码后的字符串。

// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

// 示例 1：

// 输入：s = "3[a]2[bc]"
// 输出："aaabcbc"
// 示例 2：

// 输入：s = "3[a2[c]]"
// 输出："accaccacc"
// 示例 3：

// 输入：s = "2[abc]3[cd]ef"
// 输出："abcabccdcdcdef"
// 示例 4：

// 输入：s = "abc3[cd]xyz"
// 输出："abccdcdcdxyz"
 
// 提示：

// 1 <= s.length <= 30
// s 由小写英文字母、数字和方括号 '[]' 组成
// s 保证是一个 有效 的输入。
// s 中所有整数的取值范围为 [1, 300] 

import java.util.Stack;

/**
 * Lesson394
 */
public class Lesson394 {
    public String decodeString(String s) {
        int multi=0;
        String res = "";
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        
        for(char c : s.toCharArray()){
            //数字
            if(c >='0' && c <='9') {
                multi = multi * 10 + (c-'0');
            } else if (c == '[') {
                numStack.push(multi);
                multi = 0;
                strStack.push(res);
                res="";
            } else if (c == ']') {
                int repeat = numStack.pop();
                String sss = "";
                for (int i=0;i<repeat;i++) {
                    sss += res;
                }
                res = strStack.pop() + sss;
            } else {
                //字母
                res += c;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lesson394 solution = new Lesson394();
        String res = solution.decodeString("22[ab3[bc]]");//3[a]2[bc]  32[a2[c]]  22[ab3[bc]]
        System.out.println(res);
    }
    
}