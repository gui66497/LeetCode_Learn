
//234. 回文链表
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
//示例 1:
//
//输入: 1->2
//输出: false
//示例 2:
//
//输入: 1->2->2->1
//输出: true
//进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

import java.util.ArrayList;
import java.util.List;

class Lesson234_2 {

    //解法1 转存数组 然后双指针比较
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-129);
        head.next = new ListNode(-129);
        Lesson234_2 solution = new Lesson234_2();
        boolean res = solution.isPalindrome(head);
        System.out.println("res:" + res);
    }
}