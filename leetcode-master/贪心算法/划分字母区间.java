import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            edge[charArr[i] - 'a'] = i;
        }
        int right = 0;
        int left = 0;
        for (int j = 0; j < charArr.length; j++) {
            right = Math.max(right, edge[charArr[j] - 'a']);
            if (right == j) {
                list.add(j - left + 1);
                left = right + 1;
            }
        }
        return list;
    }
}
