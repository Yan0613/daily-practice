func coinChange1(coins []int, amount int) int {
	dp := make([]int, amount+1)
	// 初始化dp[0]
	dp[0] = 0
	// 初始化为math.MaxInt32
	for j := 1; j <= amount; j++ {
		dp[j] = math.MaxInt32
	}

	// 遍历物品
	for i := 0; i < len(coins); i++ {
		// 遍历背包
		for j := coins[i]; j <= amount; j++ {
			if dp[j-coins[i]] != math.MaxInt32 {
				// 推导公式
				dp[j] = min(dp[j], dp[j-coins[i]]+1)
				//fmt.Println(dp,j,i)
				//这个if判断是在检查dp[j-coins[i]]是否仍然保持其初始值math.MaxInt32。如果dp[j-coins[i]]不是math.MaxInt32，说明我们之前已经找到了组成金额j-coins[i]的方法，并且知道组成这个金额所需的最少硬币数。
			}
		}
	}
	// 没找到能装满背包的, 就返回-1
	if dp[amount] == math.MaxInt32 {
		return -1
	}
	return dp[amount]
}


// dp 是一个数组，用于存储组成从0到amount的每一个金额所需的最少硬币数。dp[j]表示组成金额j所需的最少硬币数。
// dp[0] 被初始化为0，因为组成金额为0的硬币数是0。
// 其他dp[j]（j > 0）被初始化为math.MaxInt32，表示一个不可能的大数。