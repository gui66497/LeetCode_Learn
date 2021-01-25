// 61. 旋转链表
// 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

// 示例 1:

// 输入: 1->2->3->4->5->NULL, k = 2
// 输出: 4->5->1->2->3->NULL
// 解释:
// 向右旋转 1 步: 5->1->2->3->4->NULL
// 向右旋转 2 步: 4->5->1->2->3->NULL
// 示例 2:

// 输入: 0->1->2->NULL, k = 4
// 输出: 2->0->1->NULL
// 解释:
// 向右旋转 1 步: 2->0->1->NULL
// 向右旋转 2 步: 1->2->0->NULL
// 向右旋转 3 步: 0->1->2->NULL
// 向右旋转 4 步: 2->0->1->NULL

class Solution61 {
    // 逐步推演
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int n = 1;
        ListNode curr = head;
        while (curr.next != null) {
            n++;
            curr = curr.next;
        }
        // 去重 比如长度为3的链表 旋转三次等于没旋转
        k = k % n;

        while (k > 0) {
            // 找到倒数第二个节点 将倒数第一个节点的next纸向头 将倒数第二指向null
            curr = head;
            // 找到倒数第二个元素
            while (curr.next.next != null)
                curr = curr.next;
            // 尾节点指向头 形成环
            curr.next.next = head;
            head = curr.next;
            curr.next = null;
            k--;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution61 solution = new Solution61();
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        ListNode res = solution.rotateRight(h1, 2);
        System.out.println(res);
    }
}