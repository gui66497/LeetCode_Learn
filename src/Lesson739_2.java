import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*739. 每日温度
中等

给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
如果气温在这之后都不会升高，请在该位置用 0 来代替。

示例 1:

输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
示例 2:

输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
示例 3:

输入: temperatures = [30,60,90]
输出: [1,1,0]

提示：

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100*/

class Lesson739_2 {

    public int[] dailyTemperatures(int[] temperatures) {
        //维护一个递减栈，栈内存的是数组下标
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Lesson739_2 solution = new Lesson739_2();
        int[] res = solution.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
        System.out.println("res:" + Arrays.toString(res));
    }
}