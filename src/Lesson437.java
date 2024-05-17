/*437. 路径总和 III
中等

给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

示例 1：

输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。
示例 2：

输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：3

提示:

二叉树的节点个数的范围是 [0,1000]
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000*/

import java.util.HashMap;
import java.util.Map;

/**
 * Lesson437
 */
public class Lesson437 {
    //存储前缀和以及出现次数
    Map<Long,Integer> map;
    int target;
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        //前缀树为0的个数至少是一个 比如new TreeNode(1),target=1,这样才不会漏掉自己
        map.put(0L, 1);
        target = targetSum;
        dfs(root,0);
        return res;
    }

    public void dfs(TreeNode root, long currPreSum) {
        if (root == null) {
            return;
        }
        //当前路径和
        currPreSum += root.val;
        //得到我们想要前缀树的个数，想要前缀树值就是当前前缀树值减去目标值
        if (map.get(currPreSum - target) != null) {
            res += map.get(currPreSum - target);
        }
        map.put(currPreSum, map.getOrDefault(currPreSum, 0) + 1);

        dfs(root.left, currPreSum);
        dfs(root.right, currPreSum);
        // 防止左边前缀树影响右边前缀树，左边前缀树可能有个为6，右边正好想要一个前缀树为6的，这样子就出错了
        map.put(currPreSum, map.getOrDefault(currPreSum, 0) - 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        Lesson437 solution = new Lesson437();
        int res = solution.pathSum(treeNode, 0);
        System.out.println(res);
    }
    
}