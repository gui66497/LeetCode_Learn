
// 206. 反转链表
// 反转一个单链表。

// 示例:

// 输入: 1->2->3->4->5->NULL
// 输出: 5->4->3->2->1->NULL
// 进阶:
// 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

class Solution206 {

    public ListNode reverseList(ListNode head) {
        // 循环 双指针法
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            //当前节点指向上一个节点
            curr.next = prev;
            prev = curr;
            //当前节点后移
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution206 solution = new Solution206();
        ListNode res = solution.reverseList(head);
        System.out.println("res:" + res);
    }
}