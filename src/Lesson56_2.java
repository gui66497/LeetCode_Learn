import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 56. 合并区间
// 给出一个区间的集合，请合并所有重叠的区间。

// 示例 1:

// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
// 输出: [[1,6],[8,10],[15,18]]
// 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 示例 2:

// 输入: intervals = [[1,4],[4,5]]
// 输出: [[1,5]]
// 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。

// 提示：

// intervals[i][0] <= intervals[i][1]

class Solution56_2 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) {
            return intervals;
        }
        // 先按照起始区间排序
        Arrays.sort(intervals, (a1, a2) -> (a1[0] - a2[0]));
        List<int[]> list = new ArrayList<>();

        list.add(new int[] { intervals[0][0], intervals[0][1] });
        for (int i = 1; i < n; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (L > list.get(list.size() - 1)[1]) {
                //不重叠 加入list
                list.add(new int[] { L, R });
            } else {
                //重叠 更新R
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], R);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Solution56_2 solution = new Solution56_2();
        int[] a1 = new int[] { 1, 3 };
        int[] a2 = new int[] { 2, 3 };
        int[][] ss = new int[][] { a1, a2 };
        int[][] res = solution.merge(ss);
        System.out.println(res);
    }
}