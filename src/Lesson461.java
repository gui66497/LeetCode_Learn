// 461. 汉明距离
// 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

// 给出两个整数 x 和 y，计算它们之间的汉明距离。

// 注意：
// 0 ≤ x, y < 231.

// 示例:

// 输入: x = 1, y = 4

// 输出: 2

// 解释:
// 1   (0 0 0 1)
// 4   (0 1 0 0)
//        ↑   ↑

// 上面的箭头指出了对应二进制位不同的位置。

class Lesson461 {

    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        return Integer.bitCount(res);
    }

    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1) {
                distance += 1;
            }
            xor = xor >> 1;
        }
        return distance;
    }

    public int hammingDistance3(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            xor = xor & (xor - 1);
        }
        return distance;
    }

    public static void main(String[] args) {
        Lesson461 solution = new Lesson461();
        int res = solution.hammingDistance3(1, 2);
        System.out.println(res);
    }
}