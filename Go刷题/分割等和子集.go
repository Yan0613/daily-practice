// 分割等和子集 动态规划
// 时间复杂度O(n^2) 空间复杂度O(n)
func canPartition(nums []int) bool {
    sum := 0
    for _, num := range nums {
        sum += num
    }
    // 如果 nums 的总和为奇数则不可能平分成两个子集
    if sum % 2 == 1 {
        return false
    }
    
    target := sum / 2
    dp := make([]int, target + 1)

    for _, num := range nums {
        for j := target; j >= num; j-- {
            if dp[j] < dp[j - num] + num {
                dp[j] = dp[j - num] + num
            }
        }
    }
    return dp[target] == target
}