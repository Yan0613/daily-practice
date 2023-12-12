public class reverse2 {
    public String reverseSo(String str, int k) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i += k * 2) {
            if (i + k <= ch.length) {
                reverse(ch, i, i + k - 1);// 传入的是指针
                continue;
            } else {
                reverse(ch, i, ch.length - 1);
                continue;
            }
        }

        return new String(ch);// 记得返回String
    }

    public void reverse(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }
}
