/**
 * 不适用辅助空间的解法
 */
public class reverseWorder {
    public StringBuilder removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ')
            start++;
        while (s.charAt(end) == ' ')
            end--;
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    public void reverseAll(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public void reverseEacheWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        while (end <= sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            reverseAll(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);// 移除空格
        reverseAll(sb, 0, sb.length() - 1);// 全部翻转
        reverseEacheWord(sb);
        return sb.toString();
    }
}
