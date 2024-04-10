import java.util.Deque;
import java.util.LinkedList;
/*994. 腐烂的橘子
中等

在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。

示例 1：

输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
输出：4
示例 2：

输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
示例 3：

输入：grid = [[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。

提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] 仅为 0、1 或 2*/

class Lesson994 {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.addLast(new int[]{i, j});
                }
            }
        }
        int loopCount = 0;
        while (fresh > 0 && !queue.isEmpty()) {
            loopCount++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] nums = queue.pollFirst();
                int mP = nums[0];
                int nP = nums[1];
                if (mP -1 >= 0 && grid[mP - 1][nP] == 1) {
                    grid[mP - 1][nP] = 2;
                    fresh--;
                    queue.addLast(new int[]{mP - 1, nP});
                }
                if (mP + 1 < m && grid[mP + 1][nP] == 1) {
                    grid[mP + 1][nP] = 2;
                    fresh--;
                    queue.addLast(new int[]{mP + 1, nP});
                }
                if (nP - 1 >= 0 && grid[mP][nP - 1] == 1) {
                    grid[mP][nP - 1] = 2;
                    fresh--;
                    queue.addLast(new int[]{mP, nP - 1});
                }
                if (nP + 1 < n && grid[mP][nP + 1] == 1) {
                    grid[mP][nP + 1] = 2;
                    fresh--;
                    queue.addLast(new int[]{mP, nP + 1});
                }
            }
        }
        if (fresh > 0) {
            return -1;
        } else {
            return loopCount;
        }
    }

    public static void main(String[] args) {
        Lesson994 solution = new Lesson994();
        int[][] nums = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int res = solution.orangesRotting(nums);
        System.out.println("res:" + res);
    }
}