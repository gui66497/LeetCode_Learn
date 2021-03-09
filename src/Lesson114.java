// 114. 二叉树展开为链表
// 给你二叉树的根结点 root ，请你将它展开为一个单链表：

// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。

// 示例 1：

// 输入：root = [1,2,5,3,4,null,6]
// 输出：[1,null,2,null,3,null,4,null,5,null,6]
// 示例 2：

// 输入：root = []
// 输出：[]
// 示例 3：

// 输入：root = [0]
// 输出：[0]

// 提示：

// 树中结点数在范围 [0, 2000] 内
// -100 <= Node.val <= 100

// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？

class Lesson114 {

    public void flatten(TreeNode root) {
        while (root != null) {
            // 左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode left = root.left;
                // 找到左节点最右子节点
                while (left.right != null) {
                    left = left.right;
                }
                TreeNode next = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                // 将原来的右子树接到左子树的最右边节点
                left.right = next;
                root.left = null;
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode nodel = new TreeNode(2);
        TreeNode noder = new TreeNode(3);
        TreeNode noder2 = new TreeNode(4);
        node.left = nodel;
        node.right = noder;
        noder.left = noder2;
        Lesson114 solution = new Lesson114();
        solution.flatten(node);
        System.out.println(node);
    }
}