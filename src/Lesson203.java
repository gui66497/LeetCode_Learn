// 203. 移除链表元素
// 删除链表中等于给定值 val 的所有节点。

// 示例:

// 输入: 1->2->6->3->4->5->6, val = 6
// 输出: 1->2->3->4->5

class Lesson203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode a = dummyNode;
        ListNode b = head;
        while (b != null) {
            if (b.val == val) {
                a.next = b.next;
            } else {
                a = a.next;
            }
            b = b.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        Lesson203 solution = new Lesson203();
        ListNode res = solution.removeElements(head, 1);
        System.out.println(res);
    }
}