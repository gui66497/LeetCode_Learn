// 在一个字符串数组中有红、黄、蓝三种颜色的球，且个数不相等、顺序不一致，请为该数组排序。
// 使得排序后数组中球的顺序为:黄、红、蓝。

// 例如：红蓝蓝黄红黄蓝红红黄红，排序后为：黄黄黄红红红红红蓝蓝蓝
package other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Lesson1 {

    public String[] sort(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        map.put("黄", 3);
        map.put("红", 2);
        map.put("蓝", 1);
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String A, String B) {
                return map.get(B) - map.get(A);
            }
        });
        return arr;
    }

    public static void main(String[] args) {
        Lesson1 solution = new Lesson1();
        String[] arr = new String[] { "蓝", "黄", "蓝", "红", "黄", "蓝", "红", "黄", "蓝", "蓝", "红", "黄", "黄", "红" };
        String[] res = solution.sort(arr);
        System.out.println("res:" + Arrays.toString(res));
    }
}
