//152. 乘积最大子数组
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//
//
//示例 1:
//
//输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//示例 2:
//
//输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

class Lesson152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxF = nums[0];
        int minF = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], nums[i] * mn));
            minF = Math.min(mn * nums[i], Math.min(nums[i], nums[i] * mx));
            ans = Math.max(ans, maxF);
        }
        return ans;
    }

    public static void main(String[] args) {
        Lesson152 solution = new Lesson152();
        int res = solution.maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(res);
    }
}
