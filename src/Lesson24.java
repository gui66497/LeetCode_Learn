// 24. 两两交换链表中的节点
// 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

// 示例 1：

// 输入：head = [1,2,3,4]
// 输出：[2,1,4,3]
// 示例 2：

// 输入：head = []
// 输出：[]
// 示例 3：

// 输入：head = [1]
// 输出：[1]

// 提示：

// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummpyHead = new ListNode(-1);
        dummpyHead.next = head;
        ListNode tempNode = dummpyHead;

        while (tempNode.next != null && tempNode.next.next != null) {
            ListNode node1 = tempNode.next;
            ListNode node2 = tempNode.next.next;
            tempNode.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tempNode = node1;
        }
        return dummpyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        Solution24 solution = new Solution24();
        ListNode res = solution.swapPairs(listNode1);
        System.out.println(res);
    }
}