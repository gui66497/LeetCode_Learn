import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lesson94_2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 中序遍历 先左 再根 最后右
        // 这次用迭代实现
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            //不断往左子树方向走，每走一次就将当前节点保存到栈中
			//这是模拟递归的调用
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
			    //然后转向右边节点，继续上面整个过程
                TreeNode node = stack.pop();
                list.add(node.val);
                root = node.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode noder = new TreeNode(2);
        TreeNode noder2 = new TreeNode(3);
        node.right = noder;
        noder.left = noder2;

        Lesson94_2 solution = new Lesson94_2();
        List<Integer> res = solution.inorderTraversal(node);
        System.out.println(res);
    }
}
