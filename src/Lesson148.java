import java.util.PriorityQueue;

/*148. 排序链表
中等

给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

示例 1：

输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：

输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：

输入：head = []
输出：[]

提示：

链表中节点的数目在范围 [0, 5 * 104] 内
-105 <= Node.val <= 105

进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？*/

class Lesson148 {

    //方法1 小顶堆 不符合题意
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ListNode node = head;
        while (node != null) {
            queue.add(node.val);
            node = node.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            cur.next = new ListNode(queue.poll());
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        Lesson148 solution = new Lesson148();
        ListNode res = solution.sortList(head);
        System.out.println("res:" + res);
    }
}
