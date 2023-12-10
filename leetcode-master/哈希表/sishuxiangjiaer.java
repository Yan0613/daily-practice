import java.util.HashMap;
import java.util.Map;

/**
 * 为什么用两个N方？这样两个for循环，复杂度就是O（n2）
 * key表示要查找的键，defaultValue表示如果键不存在时返回的默认值
 */
public class sishuxiangjiaer {
    public int fourSumSort(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(0 - i - j, 0);
            }
        }
        return res;
    }
}
