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

class Lesson543_2 {
    //用于记录最终结果
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }
    int dfs(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res=Math.max(res,left+right);
        //返回值为该节点最大深度
        return Math.max(left, right) + 1;
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
        nodel.right = noder2;
        Lesson543_2 solution = new Lesson543_2();
        int res = solution.diameterOfBinaryTree(node);
        System.out.println(res);
    }
}