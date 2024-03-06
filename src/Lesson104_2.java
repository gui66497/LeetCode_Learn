// 104. 二叉树的最大深度
// 给定一个二叉树，找出其最大深度。

// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

// 说明: 叶子节点是指没有子节点的节点。

// 示例：
// 给定二叉树 [3,9,20,null,null,15,7]，

//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回它的最大深度 3 。

import java.util.LinkedList;
import java.util.Queue;

class Lesson104_2 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    public int maxDepth2(TreeNode root) {
        // BFS 层次遍历
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode noder = new TreeNode(2);
        TreeNode noder2 = new TreeNode(3);
        node.right = noder;
        noder.left = noder2;

        Lesson104_2 solution = new Lesson104_2();
        int res = solution.maxDepth(node);
        int res2 = solution.maxDepth2(node);
        System.out.println(res);
        System.out.println(res2);
    }
}