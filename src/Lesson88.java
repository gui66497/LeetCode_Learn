//88. 合并两个有序数组
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
//
//
//
//示例 1：
//
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//示例 2：
//
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//
//
//提示：
//
//nums1.length == m + n
//nums2.length == n
//0 <= m, n <= 200
//1 <= m + n <= 200
//-109 <= nums1[i], nums2[i] <= 109

class Lesson88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 两个指针 复制一份nums1出来
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);
        int p1 = 0, p2 = 0;
        while (p1 < m && p2 < n) {
            nums1[p1 + p2] = nums1Copy[p1] < nums2[p2] ? nums1Copy[p1++] : nums2[p2++];
        }
        // 剩余数直接复制进去
        if (p1 < m) {
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = new int[] { 2, 5, 6 };
        Lesson88 solution = new Lesson88();
        solution.merge(nums1, 3, nums2, 3);
        System.out.println("res:" + nums1);
    }
}