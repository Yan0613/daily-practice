import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                k--;
                nums[i] = -nums[i];
            }
            sum += nums[i];
        }
        Arrays.sort(nums);
        if (k % 2 == 0) {
            sum = sum;
        } else if (k % 2 == 1) {
            sum = sum - 2 * nums[0];
        }
        return sum;
    }
}