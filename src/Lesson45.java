// 给定一个非负整数数组，你最初位于数组的第一个位置。

// 数组中的每个元素代表你在该位置可以跳跃的最大长度。

// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

// 示例:

// 输入: [2,3,1,1,4]
// 输出: 2
// 解释: 跳到最后一个位置的最小跳跃数是 2。
//      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 说明:

// 假设你总是可以到达数组的最后一个位置。

class Lesson45 {
    public int jump(int[] nums) {
        int start = 0;
        int end = 1;
        int step = 0;
        while (end < nums.length) {
            int max = 0;
            for (int i = start; i < end; i++) {
                max = Math.max(max, nums[i] + i);
            }
            start = end;
            end = max + 1;
            step += 1;
        }
        return step;
    }

    public int jump2(int[] nums) {
        int end = 0;
        int max = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 1, 1 };
        Lesson45 solution = new Lesson45();
        int res = solution.jump2(nums);
        System.out.println(res);
    }
}