public class 加油站 {

}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int realSum = 0;
        int index = 0;
        for (int i = 0; i < cost.length; i++) {
            curSum += gas[i] - cost[i];
            realSum += gas[i] - cost[i];
            if (curSum < 0) {
                curSum = 0;
                index = (i + 1) % cost.length;
            }
        }
        if (realSum < 0) {
            return -1;
        } else {
            return index;
        }
    }
}
