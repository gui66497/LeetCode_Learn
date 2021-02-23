// 543. 二叉树的直径
// 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

// 示例 :
// 给定二叉树

//           1
//          / \
//         2   3
//        / \     
//       4   5    
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

// 注意：两结点之间的路径长度是以它们之间边的数目表示。

class Lesson543 {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        depth(root);
        return ans;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode nodel = new TreeNode(2);
        TreeNode noder = new TreeNode(3);
        TreeNode nodel2 = new TreeNode(4);
        TreeNode noder2 = new TreeNode(5);
        node.left = nodel;
        node.right = noder;
        nodel.left = nodel2;
        noder.left = noder2;
        Lesson543 solution = new Lesson543();
        int res = solution.diameterOfBinaryTree(node);
        System.out.println(res);
    }
}