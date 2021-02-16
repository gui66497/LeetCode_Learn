// 82. 删除排序链表中的重复元素 II
// 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

// 示例 1:

// 输入: 1->2->3->3->4->4->5
// 输出: 1->2->5
// 示例 2:

// 输入: 1->1->1->2->3
// 输出: 2->3

class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        // 双指针法
        if (head == null || head.next == null) {
            return head;
        }
        // 定义哑节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode a = dummyNode;
        ListNode b = head;
        while (b != null && b.next != null) {
            // 初始化的时a指向的是哑结点，所以比较逻辑应该是a的下一个节点和b的下一个节点
            if (a.next.val != b.next.val) {
                a = a.next;
                b = b.next;
            } else {
                //// 如果a、b指向的节点值相等，就不断移动b，直到a、b指向的值不相等
                while (b != null && b.next != null && a.next.val == b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        Solution82 solution = new Solution82();
        ListNode res = solution.deleteDuplicates(head);
        System.out.println("res:" + res);
    }
}