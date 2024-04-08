/*45. 跳跃游戏 II

中等

给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

0 <= j <= nums[i]
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。

示例 1:

输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
示例 2:

输入: nums = [2,3,0,1,4]
输出: 2

提示:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
题目保证可以到达 nums[n-1]*/

class Lesson45_2 {
    //顺瓜摸藤
    //我们可以「贪心」地选择距离最后一个位置最远的那个位置，也就是对应下标最小的那个位置。因此，我们可以从左到右遍历数组，选择第一个满足要求的位置。
    //找到最后一步跳跃前所在的位置之后，我们继续贪心地寻找倒数第二步跳跃前所在的位置，以此类推，直到找到数组的开始位置。
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] + i >= position) {
                    position = i;
                    step++;
                }
            }
        }
        return step;
    }

    //顺藤摸瓜
    public int jump2(int[] nums) {
        // 记录当前能跳跃到的位置的边界下标
        int border = 0;
        int n = nums.length;
        // 记录在边界范围内，能跳跃的最远位置的下标
        int maxReach = 0;
        // 记录所用步数
        int step = 0;
        for (int i = 0; i < n - 1; i++) {
            // 继续往下遍历，统计边界范围内，哪一格能跳得更远，每走一步就更新一次能跳跃的最远位置下标
            // 其实就是在统计下一步的最优情况
            maxReach = Math.max(maxReach, nums[i] + i);
            // 如果到达了边界，那么一定要跳了，下一跳的边界下标就是之前统计的最优情况maxPosition，并且步数加1
            if (i == border) {
                step++;
                border = maxReach;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        Lesson45_2 solution = new Lesson45_2();
        int res = solution.jump(nums);
        int res2 = solution.jump2(nums);
        System.out.println(res);
        System.out.println(res2);
    }
}