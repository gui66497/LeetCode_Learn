// 206. 反转链表
// 简单

// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

// 示例 1：

// 输入：head = [1,2,3,4,5]
// 输出：[5,4,3,2,1]
// 示例 2：

// 输入：head = [1,2]
// 输出：[2,1]
// 示例 3：

// 输入：head = []
// 输出：[]

// 提示：

// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000

// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？

class Solution206_2 {

    public ListNode reverseList(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            // 暂存下一节点
            ListNode tmp = curr.next;
            // 然后将当前节点指向pre
            curr.next = pre;
            // curr和pre都向后移动一位
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution206_2 solution = new Solution206_2();
        ListNode res = solution.reverseList(head);
        System.out.println("res:" + res);
    }
}