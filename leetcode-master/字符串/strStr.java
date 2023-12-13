public class strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0)
            return 0;
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        strStr ss = new strStr();
        System.out.println(ss.strStr2("hello", "ll"));
    }
}
