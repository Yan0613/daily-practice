public class rightReverse {
    /**
     * 右旋转字符串
     * 
     * @param str
     * @return
     */

    public String reverseRight(String str, int n) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, str.length() - 1);
        reverse(chars, 0, n - 1);
        reverse(chars, n, str.length() - 1);

        return new String(chars);
    }

    public char[] reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        return chars;
    }
}
