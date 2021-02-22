
// 101. 对称二叉树
// 给定一个二叉树，检查它是否是镜像对称的。

// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3

// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

//     1
//    / \
//   2   2
//    \   \
//    3    3

// 进阶：

// 你可以运用递归和迭代两种方法解决这个问题吗？

class Lesson101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 调用递归函数，比较左节点，右节点
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode left, TreeNode right) {
        // 递归的终止条件是两个节点都为空
        // 或者两个节点中有一个为空
        // 或者两个节点的值不相等
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        // 再递归的比较 左节点的左孩子 和 右节点的右孩子
        // 以及比较 左节点的右孩子 和 右节点的左孩子
        return dfs(left.left, right.right) && dfs(left.right, right.left);
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
        Lesson101 solution = new Lesson101();
        boolean res = solution.isSymmetric(node);
        System.out.println(res);
    }
}