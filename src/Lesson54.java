/*54. 螺旋矩阵
中等

给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100*/

import java.util.ArrayList;
import java.util.List;

class Lesson54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        List<Integer> res = new ArrayList<>();

        int top = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        while (true) {
            if (res.size() == total) {
                break;
            }
            //从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > down) break;
            //从上到下
            for (int i = top; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) break;
            //从右到左
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            if (--down < top) break;
            //从下到上
            for (int i = down; i >=top ; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Lesson54 solution = new Lesson54();
        List<Integer> res = solution.spiralOrder(matrix);
        System.out.println(res);
    }
}