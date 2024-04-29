/*2. 两数相加

中等

给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例 1：

输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：

输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]

提示：

每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零*/

class Lesson2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义一个新联表伪指针，用来指向头指针，返回结果
        ListNode preHead = new ListNode(0);
        //定义一个可移动的指针，用来指向存储两个数之和的位置
        ListNode prev = preHead;
        //定义一个进位数的指针，用来存储当两数之和大于10的时候，
        int carry = 0;
        while (l1 != null || l2 != null) {
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            //将两个链表的值，进行相加，并加上进位数
            int add = x + y + carry;
            //计算进位数
            carry = add / 10;
            ///计算两个数的和，此时排除超过10的请况（大于10，取余数）
            int sum = add % 10;
            //将求和数赋值给新链表的节点，
            ListNode node = new ListNode(sum);
            prev.next = node;
            //当链表l1不等于null的时候，将l1 的节点后移
            if (l1 != null) {
                l1 = l1.next;
            }
            //当链表l2 不等于null的时候，将l2的节点后移
            if (l2 != null) {
                l2 = l2.next;
            }
            //将新链表的节点后移
            prev = prev.next;
        }
        //如果最后两个数，相加的时候有进位数的时候，就将进位数，赋予链表的新节点。
        //两数相加最多小于20，所以的的值最大只能时1
        if (carry != 0) {
            prev.next = new ListNode(1);
        }
        //返回链表的头节点
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;
        Lesson2 solution = new Lesson2();
        ListNode res = solution.addTwoNumbers(l1_1,l2_1);
        System.out.println("res:" + res);
    }

}
