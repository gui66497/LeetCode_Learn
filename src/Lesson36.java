import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 36. 有效的数独
// 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

// 上图是一个部分填充的有效的数独。

// 数独部分空格内已填入了数字，空白格用 '.' 表示。

// 示例 1:

// 输入:
// [
//   ['5','3','.','.','7','.','.','.','.'],
//   ['6','.','.','1','9','5','.','.','.'],
//   ['.','9','8','.','.','.','.','6','.'],
//   ['8','.','.','.','6','.','.','.','3'],
//   ['4','.','.','8','.','3','.','.','1'],
//   ['7','.','.','.','2','.','.','.','6'],
//   ['.','6','.','.','.','.','2','8','.'],
//   ['.','.','.','4','1','9','.','.','5'],
//   ['.','.','.','.','8','.','.','7','9']
// ]
// 输出: true
// 示例 2:

// 输入:
// [
//   ['8','3','.','.','7','.','.','.','.'],
//   ['6','.','.','1','9','5','.','.','.'],
//   ['.','9','8','.','.','.','.','6','.'],
//   ['8','.','.','.','6','.','.','.','3'],
//   ['4','.','.','8','.','3','.','.','1'],
//   ['7','.','.','.','2','.','.','.','6'],
//   ['.','6','.','.','.','.','2','8','.'],
//   ['.','.','.','4','1','9','.','.','5'],
//   ['.','.','.','.','8','.','.','7','9']
// ]
// 输出: false
// 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
// 说明:

// 一个有效的数独（部分已被填充）不一定是可解的。
// 只需要根据以上规则，验证已经填入的数字是否有效即可。
// 给定数独序列只包含数字 1-9 和字符 '.' 。
// 给定数独永远是 9x9 形式的。

class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        List<Map<Character, Integer>> rows = new ArrayList<>();
        List<Map<Character, Integer>> cols = new ArrayList<>();
        List<Map<Character, Integer>> cubes = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashMap<>());
            cols.add(new HashMap<>());
            cubes.add(new HashMap<>());
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                char val = board[i][j];
                int curCube = (i / 3) * 3 + j / 3;
                if (rows.get(i).containsKey(val)) {
                    return false;
                }
                if (cols.get(j).containsKey(val)) {
                    return false;
                }
                if (cubes.get(curCube).containsKey(val)) {
                    return false;
                }

                rows.get(i).put(val, 1);
                cols.get(j).put(val, 1);
                cubes.get(curCube).put(val, 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] chars = new char[9][9];
        char[] aChar = new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' };
        char[] bChar = new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' };
        char[] cChar = new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' };
        chars[0] = aChar;
        chars[1] = bChar;
        chars[2] = cChar;
        Solution36 solution = new Solution36();
        boolean res = solution.isValidSudoku(chars);
        System.out.println(res);
    }
}