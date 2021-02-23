// 105. 从前序与中序遍历序列构造二叉树
// 根据一棵树的前序遍历与中序遍历构造二叉树。

// 注意:
// 你可以假设树中没有重复的元素。

// 例如，给出

// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
// 返回如下的二叉树：

//     3
//    / \
//   9  20
//     /  \
//    15   7

class Lesson105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        TreeNode node = myBuildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);

        return node;
    }

    private TreeNode myBuildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        // 递归出口
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 根节点
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = inLeft;
        // 得到中序遍历的中点
        while (inorder[pivotIndex] != pivot) {
            pivotIndex++;
        }
        root.left = myBuildTree(preorder, preLeft + 1, pivotIndex - inLeft + preLeft, inorder, inLeft, pivotIndex - 1);
        root.right = myBuildTree(preorder, pivotIndex - inLeft + preLeft + 1, preRight, inorder, pivotIndex + 1,
                inRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        Lesson105 solution = new Lesson105();
        TreeNode res = solution.buildTree(preorder, inorder);
        System.out.println(res);
    }
}