//苯人暴力解法
class Solution {
    public int pivotIndex(int[] nums) {
        // calculate the sum of this list
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // validate the equality
        for (int i = 0; i < nums.length; i++) {
            int sum_left = 0;
            int sum_right = 0;
            for (int j = 0; j < i; j++) {
                sum_left += nums[j];
            }
            for (int k = i + 1; k < nums.length; k++) {
                sum_right += nums[k];
            }
            if (sum_left == sum_right) {
                return i;
            }
        }
        return -1;
    }
}

// 官方聪明解法
class Solution {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
