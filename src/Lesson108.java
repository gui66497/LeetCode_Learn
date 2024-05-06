/*108. 将有序数组转换为二叉搜索树
简单

给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树。

示例 1：

输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

示例 2：

输入：nums = [1,3]
输出：[3,1]
解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。

提示：

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 按 严格递增 顺序排列*/

class Lesson108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = dfs(nums, left, mid - 1);
        midNode.right = dfs(nums, mid + 1, right);
        return midNode;
    }

    public static void main(String[] args) {
        Lesson108 solution = new Lesson108();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode res = solution.sortedArrayToBST(nums);
        System.out.println(res);
    }
}