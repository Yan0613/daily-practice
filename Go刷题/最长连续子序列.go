func lengthOfLIS(nums []int) int {  
	if len(nums) == 0 {  
		return 0  
	}  

	// dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度  
	dp := make([]int, len(nums))  
	// 初始化每个元素的最长递增子序列长度为1，因为每个元素本身就是一个长度为1的递增子序列  
	for i := range dp {  
		dp[i] = 1  
	}  

	maxLength := 1 // 最长递增子序列的长度  
	for i := 1; i < len(nums); i++ {  
		for j := 0; j < i; j++ {  
			// 如果当前元素比前一个元素大，那么可以考虑将当前元素添加到以 nums[j] 结尾的递增子序列中  
			if nums[i] > nums[j] {  
				dp[i] = max(dp[i], dp[j]+1)  
			}  
		}  
		// 更新最长递增子序列的长度  
		maxLength = max(maxLength, dp[i])  
	}  

	return maxLength  
} 