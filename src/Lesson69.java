// 69. x 的平方根
// 实现 int sqrt(int x) 函数。

// 计算并返回 x 的平方根，其中 x 是非负整数。

// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

// 示例 1:

// 输入: 4
// 输出: 2
// 示例 2:

// 输入: 8
// 输出: 2
// 说明: 8 的平方根是 2.82842..., 
//      由于返回类型是整数，小数部分将被舍去。

class Solution69 {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int l = 0, r = x;
        //采用模板2 参考：https://www.jianshu.com/p/b6ad653fb2e1
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (mid > x / mid) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution69 solution = new Solution69();
        int res1 = solution.mySqrt(8);
        System.out.println("res1：" + res1);
    }
}