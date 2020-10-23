/* 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49
 */

class Solution11 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;

        int maxRes = 0;
        while(l<r){
            int res = cal(height, l, r);
            if (res>maxRes){
                maxRes = res;
            }
            if(height[l]>height[r]){
                r--;
            } else{
                l++;
            }
        }
        return maxRes;
    }

    int cal(int[] height, int a, int b){
        return Math.abs(a-b) * Math.min(height[a], height[b]);
    }

    public static void main(String[] args) {
        int[] o = new int[9];
        o[0] = 1;
        o[1] = 8;
        o[2] = 6;
        o[3] = 2;
        o[4] = 5;
        o[5] = 4;
        o[6] = 8;
        o[7] = 3;
        o[8] = 7;
        Solution11 solution = new Solution11();
        int res = solution.maxArea(o);
        System.out.println("res:"+res);
    }
}