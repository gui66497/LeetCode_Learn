
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

    // 动态编程 提前准备两个数组存储每个点左边和右边的最大值
    public int trap2(int[] height) {
        int res = 0;
        int length = height.length;
        int[] leftArr = new int[length];
        int[] rightArr = new int[length];
        leftArr[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftArr[i] = Math.max(height[i], leftArr[i - 1]);
        }
        rightArr[length - 1] = height[length - 1];
        for (int j = length - 2; j >= 0; j--) {
            rightArr[j] = Math.max(height[j], rightArr[j + 1]);
        }
        for (int m = 1; m < length - 1; m++) {
            int val = Math.min(leftArr[m], rightArr[m]) - height[m];
            if (val > 0) {
                res += Math.min(leftArr[m], rightArr[m]) - height[m];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 2, 0, 3, 2, 5 };
        Solution42 solution = new Solution42();
        int res = solution.trap(nums);
        int res2 = solution.trap2(nums);
        System.out.println(res);
        System.out.println(res2);
    }
}