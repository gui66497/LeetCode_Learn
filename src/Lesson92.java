// 92. 反转链表 II
// 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

// 说明:
// 1 ≤ m ≤ n ≤ 链表长度。

// 示例:

// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
// 输出: 1->4->3->2->5->NULL

class Lesson92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 头插法
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;
        int step = 0;
        while (step < m - 1) {
            g = g.next;
            p = p.next;
            step++;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Lesson92 solution = new Lesson92();
        ListNode res = solution.reverseBetween(head, 2, 4);
        System.out.println("res:" + res);
    }
}