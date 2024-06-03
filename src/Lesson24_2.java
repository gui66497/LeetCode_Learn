/*24. 两两交换链表中的节点

中等

给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

示例 1：

输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]

提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100*/

class Lesson24_2 {
    public ListNode swapPairs(ListNode head) {
        //a-b-c-d-e
        //b-a-d-c-e
        ListNode dummy = new ListNode(0, head);
        ListNode tmp = dummy;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode a = tmp.next;
            ListNode b = tmp.next.next;
            //开始交换
            tmp.next = b;
            a.next = b.next;
            b.next = a;
            tmp = a;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        Lesson24_2 solution = new Lesson24_2();
        ListNode res = solution.swapPairs(listNode1);
        System.out.println(res);
    }
}