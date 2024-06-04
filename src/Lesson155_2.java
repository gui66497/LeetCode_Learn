import java.util.LinkedList;

// 155. 最小栈
// 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。

// 示例:

// 输入：
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// 输出：
// [null,null,null,null,-3,null,0,-2]

// 解释：
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> 返回 -3.
// minStack.pop();
// minStack.top();      --> 返回 0.
// minStack.getMin();   --> 返回 -2.

// 提示：

// pop、top 和 getMin 操作总是在 非空栈 上调用。

class Lesson155_2 {
    class MinStack {

        LinkedList<Integer> list;
        LinkedList<Integer> minList;

        public MinStack() {
            list = new LinkedList<>();
            minList = new LinkedList<>();
        }

        public void push(int val) {
            list.push(val);
            if (minList.isEmpty()) {
                minList.push(val);
            } else if (val <= minList.peek()) {
                minList.push(val);
            }
        }

        public void pop() {
            int tmp = list.pop();
            if (minList.peek() == tmp) {
                minList.pop();
            }
        }

        public int top() {
            return list.peek();
        }

        public int getMin() {
            return minList.peek();
        }
    }

    public static void main(String[] args) {
        Lesson155_2 lesson = new Lesson155_2();
        MinStack minStack = lesson.new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());; // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());; // --> 返回 0.
        System.out.println(minStack.getMin());; // --> 返回 -2.
    }
}
