import java.util.ArrayList;
import java.util.List;

// 57. 插入区间
// 给出一个无重叠的 ，按照区间起始端点排序的区间列表。

// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

// 示例 1：

// 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
// 输出：[[1,5],[6,9]]
// 示例 2：

// 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// 输出：[[1,2],[3,10],[12,16]]
// 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

// 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> ans = new ArrayList<>();
        boolean placed = false;
        // 遍历元素
        for (int[] inter : intervals) {
            // 新区间在最左边 没有任何交集
            if (inter[0] > right) {
                // 防止重复加入
                if (!placed) {
                    ans.add(new int[] { left, right });
                    placed = true;
                }
                ans.add(inter);
            } else if (inter[1] < left) {
                // 新区间在当前区间右边 没有交集
                ans.add(inter);
            } else {
                // 新区间和当前区间有交集 则合并区间
                left = Math.min(inter[0], left);
                right = Math.max(inter[1], right);
            }
        }
        if (!placed) {
            ans.add(new int[] { left, right });
        }
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = { { 2, 5 }, { 6, 7 }, { 8, 9 } };
        int[] b = { 0, 1 };
        Solution57 solution = new Solution57();
        int[][] res = solution.insert(a, b);
        System.out.println(res);
    }
}