import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 102. 二叉树的层序遍历
// 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

// 示例：
// 二叉树：[3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回其层序遍历结果：

// [
//   [3],
//   [9,20],
//   [15,7]
// ]

class Lesson102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 通过BFS实现
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            // n为该层结点数量
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                System.out.println(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode nodel = new TreeNode(2);
        TreeNode noder = new TreeNode(3);
        TreeNode nodel2 = new TreeNode(4);
        TreeNode noder2 = new TreeNode(5);
        node.right = noder;
        node.left = nodel;
        nodel.left = nodel2;
        noder.right = noder2;

        Lesson102 solution = new Lesson102();
        List<List<Integer>> res = solution.levelOrder(node);
        System.out.println(res);
    }
}