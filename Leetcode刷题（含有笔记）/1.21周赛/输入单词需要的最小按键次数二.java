import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumPushes(String word) {
        // 统计每个字母出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int v = map.get(c);
            if (v == 0) {
                map.put(c, 1);
            } else {
                v++;
                map.put(c, v);
            }
        }
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        int res = 0;
        for (int i = 0; i < ((CharSequence) entryList).length(); i++) {
            int value = entryList.get(i).getValue();
            if (i <= 8 - 1) {
                res += value;
            } else if (i > 7 && i <= 15) {
                res += 2 * value;
            } else if (i > 15 && i <= 24) {
                res += 3 * value;
            } else if (i > 24 && i <= 26) {
                res += 4 * value;
            }
        }
        return res;
    }
}