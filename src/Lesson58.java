// 58. 最后一个单词的长度
// 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

// 如果不存在最后一个单词，请返回 0 。

// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

// 示例:

// 输入: "Hello World"
// 输出: 5

class Solution58 {
    public int lengthOfLastWord(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int count = 0;
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        for (int i = end; i >= 0; i--) {
            if (s.charAt(i)==' ') {
                break;
            } else {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution58 solution = new Solution58();
        int res = solution.lengthOfLastWord("b   a    ");
        System.out.println(res);
    }
}