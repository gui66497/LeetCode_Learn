
// 剑指 Offer 22. 链表中倒数第k个节点
// 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 2 个节点是值为 4 的节点。

// 示例：

// 给定一个链表: 1->2->3->4->5, 和 k = 2.

// 返回链表 4->5.

class Lesson22_offer {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode front = head;
        ListNode back = head;
        for (int i = 0; i < k; i++) {
            front = front.next;
        }
        while (front != null) {
            back = back.next;
            front = front.next;
        }
        return back;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Lesson22_offer solution = new Lesson22_offer();
        ListNode res1 = solution.getKthFromEnd(head, 2);
        System.out.println(res1);
    }
}
