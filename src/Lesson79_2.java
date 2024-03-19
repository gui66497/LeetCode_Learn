//79. 单词搜索
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//示例:
//
//board =
//[
//['A','B','C','E'],
//['S','F','C','S'],
//['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
//
//
//提示：
//
//board 和 word 中只包含大写和小写英文字母。
//1 <= board.length <= 200
//1 <= board[i].length <= 200
//1 <= word.length <= 10^3

import java.util.Arrays;

class Lesson79_2 {

    boolean result = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length;// 行数
        int n = board[0].length;// 列数
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                fun(visited, board, word, 0, i, j);
            }
        }
        return result;
    }

    public void fun(boolean[][] visited, char[][] board, String word, int index, int x, int y) {
        if (index == word.length()) {
            result = true;
            return;
        }
        if (!(x >= 0 && y >= 0 && x < board.length && y < board[0].length)) {
            // 如果不在范围内
            return;
        }

        char cur = word.charAt(index);
        if (cur != board[x][y]) {
            // 如果不相等
            return;
        }

        if (cur == board[x][y] && !visited[x][y]) {
            // 如果相等，并且当前元素没有被使用过
            visited[x][y] = true;
            fun(visited, board, word, index + 1, x + 1, y);
            fun(visited, board, word, index + 1, x - 1, y);
            fun(visited, board, word, index + 1, x, y - 1);
            fun(visited, board, word, index + 1, x, y + 1);
            visited[x][y] = false;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        Lesson79_2 solution = new Lesson79_2();
        boolean res = solution.exist(board, "ABCCED");
        System.out.println("res:" + res);
    }
}