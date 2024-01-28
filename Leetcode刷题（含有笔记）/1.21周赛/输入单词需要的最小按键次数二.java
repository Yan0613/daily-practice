import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int minimumPushes(String word) {
        // 可用的只有2~9共8个按键
        int keyNum = 8;
        // 1、统计各字符出现次数
        HashMap<Character, Integer> charCntMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCntMap.put(c, charCntMap.getOrDefault(c, 0) + 1);
        }

        // 2、按值从大到小排序
        List<Integer> charCntList = new ArrayList<>(charCntMap.values());
        charCntList.sort((i1, i2) -> {
            return i2.compareTo(i1);
        });

        // 3、累加。使用贪心策略，点击次数越多的字母，分配在每个按键的位置就越靠前
        int rs = 0;
        // 分配在每个按键的位置
        int index = 0;
        for (int i = 1; i <= charCntList.size(); i++) {
            if (i % keyNum == 1) {
                // 上一个位置都已经分配完
                index++;
            }
            // 例：c被分配在按键的第index位，则每次c要按index次；word中共有charCntList.get(i)个c
            rs += index * charCntList.get(i - 1);
        }

        return rs;
    }
}
