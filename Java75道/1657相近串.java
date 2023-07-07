import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        //1、单词长度不一样直接false
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] chars = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        //统计两个字符串字符数量和位置
        int[] help1 = new int[26];
        for (Character c : chars) {
            help1[c-'a']++;
        }
        int[] help2 = new int[26];
        for (Character c : chars2) {
            help2[c-'a']++;
        }
        //排序前判断两个数组字符分布位置是否一致表示元素种类一致
        for (int i = 0; i < help1.length ; i++) {
            if (help1[i] > 0 && help2[i] == 0) {
                return false;
            }
            if (help1[i] == 0 && help2[i] > 0) {
                return false;
            }
        }
        //排序后，如果数组每个位置元素数量相等，代表可用题目解法二交换
        Arrays.sort(help1);
        Arrays.sort(help2);
        for (int i = 0; i < help1.length ; i++) {
            if (help1[i] != help2[i]) {
                return false;
            }
        }
        return true;
    }
}
