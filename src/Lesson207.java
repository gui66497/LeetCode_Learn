import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*207. 课程表
中等

你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

示例 1：

输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
示例 2：

输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。

提示：

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
prerequisites[i] 中的所有课程对 互不相同*/

class Lesson207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        //领接表 例如学习了0可以减少哪些课
        Map<Integer, List<Integer>> map = new HashMap<>();
        //每个课程的入度
        int[] nums = new int[numCourses];
        for (int i = 0; i < n; i++) {
            List<Integer> temp = map.getOrDefault(prerequisites[i][1], new ArrayList<>());
            temp.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], temp);
            nums[prerequisites[i][0]] = nums[prerequisites[i][0]] + 1;
        }

        Deque<Integer> deque = new LinkedList<>();
        //将所有入度为0的课程入队
        for (int i = 0; i < numCourses; i++) {
            if (nums[i] == 0) {
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()) {
            //出队 代表学过了
            int now = deque.poll();
            //课程-1 减到0表示能全部学完
            numCourses--;
            //得到学些了课程now 哪些课程可以相应减少
            List<Integer> list = map.get(now);
            if (list == null) {
                continue;
            }
            for (int i : map.get(now)) {
                nums[i]--;
                if (nums[i] == 0) {
                    deque.offer(i);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 0}};
        Lesson207 solution = new Lesson207();
        boolean res = solution.canFinish(2, nums);
        System.out.println(res);
    }
}