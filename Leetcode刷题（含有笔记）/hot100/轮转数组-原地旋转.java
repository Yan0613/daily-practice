class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // 处理 k 超过数组长度的情况，避免不必要的循环
        k = k % n;

        // 全数组反转
        reverse(nums, 0, n - 1);

        // 反转前 k 个元素
        reverse(nums, 0, k - 1);

        // 反转剩余的元素
        reverse(nums, k, n - 1);
    }

    // 辅助函数：反转数组中[start, end]范围内的元素
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
