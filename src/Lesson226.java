// 226. 翻转二叉树

// 简单

// 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

// 示例 1：

// 输入：root = [4,2,7,1,3,6,9]
// 输出：[4,7,2,9,6,3,1]
// 示例 2：

// 输入：root = [2,1,3]
// 输出：[2,3,1]
// 示例 3：

// 输入：root = []
// 输出：[]

// 提示：

// 树中节点数目范围在 [0, 100] 内
// -100 <= Node.val <= 100

class Lesson226 {

    public TreeNode invertTree(TreeNode root) {
        // 递归函数的终止条件，节点为空时返回
        if (root == null) {
            return null;
        }
        // 下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 递归交换当前节点的 左子树
        invertTree(root.left);
        // 递归交换当前节点的 右子树
        invertTree(root.right);
        // 函数返回时就表示当前这个节点，以及它的左右子树
        // 都已经交换完了
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode noder = new TreeNode(2);
        TreeNode nodel = new TreeNode(3);
        node.right = noder;
        node.left = nodel;
        Lesson226 solution = new Lesson226();
        TreeNode res = solution.invertTree(node);
        System.out.println("res:" + res);
    }
}