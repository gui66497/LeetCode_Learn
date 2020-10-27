import java.util.ArrayList;
import java.util.List;

// 144. 二叉树的前序遍历
// 给定一个二叉树，返回它的 前序 遍历。

//  示例:

// 输入: [1,null,2,3]  
//    1
//     \
//      2
//     /
//    3 

// 输出: [1,2,3]
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }

    void preorder(List<Integer> res, TreeNode node) {
        if (node != null) {
            res.add(node.val);
            preorder(res, node.left);
            preorder(res, node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        Solution144 solution = new Solution144();
        List<Integer> res = solution.preorderTraversal(node1);
        System.out.println(res);
    }
}
