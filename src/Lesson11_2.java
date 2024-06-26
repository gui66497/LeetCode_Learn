// 11. 盛最多水的容器
// 中等
// 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

// 返回容器可以储存的最大水量。

// 说明：你不能倾斜容器。

// 示例 1：

// 输入：[1,8,6,2,5,4,8,3,7]
// 输出：49 
// 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
// 示例 2：

// 输入：height = [1,1]
// 输出：1

// 提示：

// n == height.length
// 2 <= n <= 105
// 0 <= height[i] <= 104

class Solution11_2 {

    public int maxArea(int[] height) {
        // 若向内移动短板 ，水槽的短板 min(h[i],h[j])min(h[i], h[j])min(h[i],h[j]) 可能变大，因此下个水槽的面积可能增大
        // 若向内移动长板 ，水槽的短板 min(h[i],h[j])min(h[i], h[j])min(h[i],h[j])​ 不变或变小，因此下个水槽的面积一定变小 。
        // 所以每次向内移动短板即可
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (left >= right) {
                break;
            }
            int lVal = height[left];
            int rVal = height[right];
            int res = (right - left) * Math.min(lVal, rVal);
            max = Math.max(max, res);
            if (lVal > rVal) {
                // 左边为长板，要收缩短板
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] o = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        Solution11_2 solution = new Solution11_2();
        int res = solution.maxArea(o);
        System.out.println("res:" + res);
    }
}