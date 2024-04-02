// 199. 二叉树的右视图
// 中等
// 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

// 示例 1:

// 输入: [1,2,3,null,5,null,4]
// 输出: [1,3,4]
// 示例 2:

// 输入: [1,null,3]
// 输出: [1,3]
// 示例 3:

// 输入: []
// 输出: []

// 提示:

// 二叉树的节点个数的范围是 [0,100]
// -100 <= Node.val <= 100 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lesson199 {
    //BFS 利用 BFS 进行层次遍历，记录下每层的最后一个元素。
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
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
                if (i == size - 1) { //将当前层的最后一个节点放入结果列表
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode noder1 = new TreeNode(2);
        TreeNode noder2 = new TreeNode(3);
        TreeNode noder11 = new TreeNode(4);
        TreeNode noder22 = new TreeNode(5);
        node.left = noder1;
        node.right = noder2;
        noder1.right = noder22;
        noder2.right = noder11;
        Lesson199 solution = new Lesson199();
        List<Integer> res = solution.rightSideView(node);
        System.out.println(res);
    }
}
