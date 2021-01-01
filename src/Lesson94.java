import java.util.ArrayList;
import java.util.List;

// 给定一个二叉树的根节点 root ，返回它的 中序 遍历。

//  

// 示例 1：


// 输入：root = [1,null,2,3]
// 输出：[1,3,2]
// 示例 2：

// 输入：root = []
// 输出：[]
// 示例 3：

// 输入：root = [1]
// 输出：[1]
// 示例 4：


// 输入：root = [1,2]
// 输出：[2,1]
// 示例 5：


// 输入：root = [1,null,2]
// 输出：[1,2]
//  

// 提示：

// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//  

// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

class Solution94 {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        trace(root, res);
        return res;
    }

    public void trace(TreeNode node,List<Integer> res){
        if (node != null){
            trace(node.left, res);
            res.add(node.val);
            trace(node.right, res);
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode noder = new TreeNode(2);
        TreeNode noder2 = new TreeNode(3);
        node.right = noder;
        noder.left = noder2;
        
        Solution94 solution = new Solution94();
        List<Integer> res = solution.inorderTraversal(node);
        System.out.println(res);
    }
}