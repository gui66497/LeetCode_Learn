// 230. 二叉搜索树中第K小的元素;
// 中等;

// 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。;

// 示例 1：;

// 输入：root = [3,1,4,null,2], k = 1;
// 输出：1;
// 示例 2：;

// 输入：root = [5,3,6,2,4,null,null,1], k = 3;
// 输出：3;

// 提示：;

// 树中的节点数为 n 。;
// 1 <= k <= n <= 104;
// 0 <= Node.val <= 104;

// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？;

import java.util.PriorityQueue;
import java.util.Stack;

public class Lesson230 {
    public int kthSmallest(TreeNode root, int k) {
        // 遍历一遍 排序 返回a[k]即可
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        loofSelf(root, queue);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = queue.poll();
        }
        return res;
    }

    /*
     * 解法2 二叉搜索树的中序遍历就是从小到大
     */
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            --k;
            root = stack.pop();
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    void loofSelf(TreeNode root, PriorityQueue<Integer> queue) {
        if (root == null) {
            return;
        }
        queue.offer(root.val);
        loofSelf(root.left, queue);
        loofSelf(root.right, queue);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        node.left = node1;
        node.right = node2;
        node1.right = node3;

        Lesson230 solution = new Lesson230();
        int res = solution.kthSmallest(node, 1);
        System.out.println(res);
        int res2 = solution.kthSmallest2(node, 1);
        System.out.println(res2);
    }

}