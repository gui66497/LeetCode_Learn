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

class Solution56 {
    public int[][] merge(int[][] intervals) {
        // 先按照起始区间排序
        Arrays.sort(intervals, (a1, a2) -> (a1[0] - a2[0]));
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            // 如果和上衣区间不重叠或者报错区间为空 则直接加入
            if (res.size() == 0 || res.get(res.size() - 1)[1] < L) {
                res.add(new int[] { L, R });
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], R);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Solution56 solution = new Solution56();
        int[] a1 = new int[] { 1, 3 };
        int[] a2 = new int[] { 2, 6 };
        int[] a3 = new int[] { 8, 10 };
        int[] a4 = new int[] { 15, 18 };
        int[][] ss = new int[][] { a1, a2, a3, a4 };
        int[][] res = solution.merge(ss);
        System.out.println(res);
    }
}