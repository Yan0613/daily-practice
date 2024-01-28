import java.util.TreeMap;

class Solution {
    public static int maximumLength(int[] nums) {
        // Arrays.sort(nums);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : nums)
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);

        // 1要特殊处理一下。
        int res = 1;
        if (treeMap.containsKey(1) && treeMap.get(1) >= 3) {
            int value = treeMap.get(1);
            if (value % 2 == 0)
                res = value - 1; // 偶数个 那就是个数减一个，因为山峰不能配对，所以要减一。
            if (value % 2 == 1)
                res = value; // 奇数个 那就是本身。
        }
        treeMap.remove(1);

        for (int i : treeMap.keySet()) {
            if (handle(i) == -1)
                continue;

            int cnt = 1;
            int now = i;
            while (handle(now) != -1 && treeMap.containsKey(handle(now)) && treeMap.get(handle(now)) >= 2) {
                cnt = cnt + 2;
                now = handle(now);
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    // 开不了，那当前就是最开始的x，那就返回-1？
    public static int handle(int x) {
        double sq = Math.sqrt(x);
        if ((int) sq * (int) sq == x)
            return (int) sq;

        return -1;
    }
}
