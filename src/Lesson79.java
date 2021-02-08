//79. 单词搜索
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
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

class Solution79 {

    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        // 存储是否访问过
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean res = dfs(board, visited, word, i, j, 0);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        // 四个方向
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited[i][j] = true;
        for (int m = 0; m < directions.length; m++) {
            int nextI = i + directions[m][0];
            int nextJ = j + directions[m][1];
            // 判断是否越界以及是否访问过
            if (nextI >= 0 && nextI < visited.length && nextJ >= 0 && nextJ < visited[0].length && !visited[nextI][nextJ]) {
                boolean res = dfs(board, visited, word, nextI, nextJ, index + 1);
                if (res) {
                    return true;
                }
            }
        }
        // 回溯 状态重置
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        Solution79 solution = new Solution79();
        boolean res = solution.exist(board, "ABCCED");
        System.out.println("res:" + res);
    }
}