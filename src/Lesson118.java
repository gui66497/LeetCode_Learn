// 118. 杨辉三角
// 简单

// 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。

// 示例 1:

// 输入: numRows = 5
// 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 示例 2:

// 输入: numRows = 1
// 输出: [[1]]

// 提示:

// 1 <= numRows <= 30

import java.util.ArrayList;
import java.util.List;

class Lesson118 {

    public List<List<Integer>> generate(int numRows) {
        //第i行的第j个数=第i-1行的j-1个数 + 第i-1行的第j个数。注意下，左右边界都是1。
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> ret = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ret.add(1);
                } else {
                    ret.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(ret);
        }
        return res;
    }

    public static void main(String[] args) {
        Lesson118 solution = new Lesson118();
        List<List<Integer>> res = solution.generate(4);
        System.out.println(res);
    }
}