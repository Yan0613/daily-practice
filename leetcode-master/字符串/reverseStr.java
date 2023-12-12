public class reverseStr {
    public String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public void reverse2(char[] str) {
        int l = 0;
        int r = str.length - 1;
        while (l < r) {
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l++;
            r--;
        }
    }
}
