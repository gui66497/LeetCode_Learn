/*73. 矩阵置零

中等

给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。

示例 1：

输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
输出：[[1,0,1],[0,0,0],[1,0,1]]
示例 2：

输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

提示：

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1

进阶：

一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个仅使用常量空间的解决方案吗？*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Lesson73_2 {

//    思路一: 用 O(m+n)额外空间
//    两遍扫matrix,第一遍用集合记录哪些行,哪些列有0;第二遍置0
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //思路2 使用矩阵的第一行和第一列代替方法一中的两个标记数组
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0]==0) {
                col0 = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i]==0) {
                row0 = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row0){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col0){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int[][] matrix2 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        Lesson73_2 solution = new Lesson73_2();
        solution.setZeroes(matrix);
        solution.setZeroes2(matrix2);
        System.out.println("res:" + Arrays.deepToString(matrix));
        System.out.println("res2:" + Arrays.deepToString(matrix2));
    }
}