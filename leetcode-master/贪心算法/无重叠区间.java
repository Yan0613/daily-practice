import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int ans = 0;
        if (intervals.length == 1) {
            ans = 0;
        }
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[i - 1][1]) {
                // continue
            } else {
                // 移除
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
                ans++;
            }
        }
        return ans;
    }
}