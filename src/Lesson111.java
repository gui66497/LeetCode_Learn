import java.util.Deque;
import java.util.LinkedList;

// 111. 二叉树的最小深度
// 给定一个二叉树，找出其最小深度。

// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

// 说明：叶子节点是指没有子节点的节点。

// 示例 1：


// 输入：root = [3,9,20,null,null,15,7]
// 输出：2
// 示例 2：

// 输入：root = [2,null,3,null,4,null,5,null,6]
// 输出：5
 

// 提示：

// 树中节点数的范围在 [0, 105] 内
// -1000 <= Node.val <= 1000

class Lesson111 {

    public int minDepth(TreeNode root) {
        // 深度优先搜索
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        if (root.left != null) {
            ans = Math.min(minDepth(root.left), ans);
        }
        if (root.right != null) {
            ans = Math.min(minDepth(root.right), ans);
        }
        return ans + 1;
    }

    public int minDepth2(TreeNode root) {
        // 广度优先搜索
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left == null && tmp.right == null) {
                    return depth;
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            depth++;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode noder = new TreeNode(2);
        TreeNode noder2 = new TreeNode(3);
        node.right = noder;
        noder.left = noder2;

        Lesson111 solution = new Lesson111();
        int res = solution.minDepth(node);
        System.out.println(res);
        int res2 = solution.minDepth2(node);
        System.out.println(res2);
    }
}