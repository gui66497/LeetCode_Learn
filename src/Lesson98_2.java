// 98. 验证二叉搜索树
// 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

// 假设一个二叉搜索树具有如下特征：

// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
// 示例 1:

// 输入:
//     2
//    / \
//   1   3
// 输出: true
// 示例 2:

// 输入:
//     5
//    / \
//   1   4
//      / \
//     3   6
// 输出: false
// 解释: 输入为: [5,1,4,null,null,3,6]。
//      根节点的值为 5 ，但是其右子节点值为 4 。

class Lesson98_2 {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        //二叉搜索树的中序遍历一定是升序的
        //中序遍历：先左子树-再根节点-最后右子树
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        //访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

    public boolean isValidBST2(TreeNode root) {
        return dg(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean dg(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        if (!dg(node.left, min, node.val)) {
            return false;
        }
        if (!dg(node.right, node.val, max)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode nodel = new TreeNode(2);
        TreeNode noder = new TreeNode(3);
        node.right = noder;
        node.left = nodel;
        Lesson98_2 solution = new Lesson98_2();
        boolean res = solution.isValidBST(node);
        System.out.println(res);
    }
}