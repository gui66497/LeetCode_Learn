
// 42. 接雨水
// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

// 示例 1：

// 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
// 输出：6
// 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 示例 2：

// 输入：height = [4,2,0,3,2,5]
// 输出：9

// 提示：

// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105

class Solution42 {

    // 暴力法 当前节点的水量等于其两边高度最大值的较小值减去当前高度
    public int trap(int[] height) {
        int length = height.length;
        int res = 0;
        for (int i = 1; i < length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int m = i + 1; m < length; m++) {
                rightMax = Math.max(height[m], rightMax);
            }
            for (int n = 0; n < i; n++) {
                leftMax = Math.max(height[n], leftMax);
            }
            if ((Math.min(leftMax, rightMax) - height[i]) > 0) {
                res += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        Solution42 solution = new Solution42();
        int res = solution.trap(nums);
        System.out.println(res);
    }
}