class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }

        char[] allChars = s.toCharArray();
        int right = s.length() - 1;
        int maxLen = 0;
        int recordL = 0;
        int recordR = right;
        for (int i = 0; i < right; i++) {
            for (int j = right; j > i; j--) {
                if (isHuiWen(allChars, i, j)) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        recordL = i;
                        recordR = j;
                    }
                }
            }
        }
        if (maxLen == 0) {
            return s.substring(0, 1);
        }

        return s.substring(recordL, recordR + 1);
    }

    // 判断是否是回文
    boolean isHuiWen(char[] chars, int left, int right) {
        int l = left;
        int r = right;
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcda";
        Solution solution = new Solution();
        String res = solution.longestPalindrome(str);
        System.out.println("res:" + res);
    }

}
