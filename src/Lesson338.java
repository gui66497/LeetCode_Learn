import java.util.Arrays;

// 338. 比特位计数
// 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

// 示例 1:

// 输入: 2
// 输出: [0,1,1]
// 示例 2:

// 输入: 5
// 输出: [0,1,1,2,1,2]
// 进阶:

// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
// 要求算法的空间复杂度为O(n)。
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。

class Lesson338 {

    public int[] countBits(int num) {
        // 0 000 1 001
        // 2 010 3 011
        // 4 100 5 101
        // 6 110 7 111
        // 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
        // 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                // 偶数
                res[i] = res[i / 2];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lesson338 solution = new Lesson338();
        int[] res = solution.countBits(5);
        System.out.println("res:" + Arrays.toString(res));
    }
}