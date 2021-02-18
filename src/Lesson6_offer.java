import java.util.Deque;
import java.util.LinkedList;

// 剑指 Offer 06. 从尾到头打印链表
// 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

// 示例 1：

// 输入：head = [1,3,2]
// 输出：[2,3,1]

class Lesson6_offer {

    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int n = stack.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Lesson6_offer solution = new Lesson6_offer();
        int[] res = solution.reversePrint(head);
        System.out.println(res);
    }
}
