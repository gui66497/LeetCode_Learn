import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 739. 每日温度
// 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

class Lesson739 {

    public int[] dailyTemperatures(int[] T) {
        // 通过栈解决
        // 存数组的index
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Lesson739 solution = new Lesson739();
        int[] res = solution.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
        System.out.println("res:" + Arrays.toString(res));
    }
}