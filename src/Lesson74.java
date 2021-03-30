// 74. 搜索二维矩阵
// 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。

// 示例 1：

// 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// 输出：true
// 示例 2：

// 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// 输出：false

// 提示：

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104

class Lesson74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 一次二分
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0, high = row * col - 1;
        while (low < high) {
            int mid = low + high >>> 1;
            int x = matrix[mid / col][mid % col];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return matrix[low / col][low % col] == target;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        Lesson74 solution = new Lesson74();
        boolean res = solution.searchMatrix(matrix, 3);
        System.out.println("res:" + res);
    }
}