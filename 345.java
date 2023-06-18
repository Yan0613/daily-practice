class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        if (n <= 1) return s;

        char[] arr = s.toCharArray();

        int left = 0, right = n - 1;
        while (left < right) {
            // 相等则交换
            if (isVowel(arr[left]) && isVowel(arr[right])) {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;

                left++;
                right--;
            }

            // 左指针不是元音，右移一位
            if (!isVowel(arr[left])) left++;
            // 右指针不是元音，左移一位
            if (!isVowel(arr[right])) right--;
        }
        
        return new String(arr);
    }

    // 这里也可以使用List、Set、String代替快速查找
    public boolean isVowel(char c) {
        return c == 'a' || c == 'A'
                || c == 'e' || c == 'E'
                || c == 'i' || c == 'I'
                || c == 'o' || c == 'O'
                || c == 'u' || c == 'U';
    }
}
