/*42. 接雨水

困难

给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例 1：

输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9

提示：

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105*/

class Lesson42_2 {
    //暴力法 遍历每个点 找左边的最大值 右边的最大值 用较小的哪个减去高度 就是该点的雨水量
    //超出时间限制
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        for (int i = 1; i < n; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            if (Math.min(leftMax, rightMax) - height[i] > 0) {
                res += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return res;
    }

    //利用动态规划的思想 提前得到每个点位的leftMax和rightMax
    public int trap2(int[] height) {
        int res = 0;
        int n = height.length;
        int[] leftArr = new int[n];
        leftArr[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftArr[i] = Math.max(leftArr[i - 1], height[i]);
        }
        int[] rightArr = new int[n];
        rightArr[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightArr[i] = Math.max((height[i]), rightArr[i + 1]);
        }
        for (int i = 1; i < n; i++) {
            int m = Math.min(leftArr[i], rightArr[i]);
            if (m - height[i] > 0) {
                res += (m - height[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Lesson42_2 solution = new Lesson42_2();
        int res = solution.trap(nums);
        int res2 = solution.trap2(nums);
        System.out.println(res);
        System.out.println(res2);
    }
}