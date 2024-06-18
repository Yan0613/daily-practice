func minPathSum(grid [][]int) int {  
	if len(grid) == 0 || len(grid[0]) == 0 {  
		return 0  
	}  
  
	rows, cols := len(grid), len(grid[0])  
	dp := make([][]int, rows)  
	for i := range dp {  
		dp[i] = make([]int, cols)  
	}  
  
	// 初始化第一行  
	dp[0][0] = grid[0][0]  
	for j := 1; j < cols; j++ {  
		dp[0][j] = dp[0][j-1] + grid[0][j]  
	}  
  
	// 初始化第一列  
	for i := 1; i < rows; i++ {  
		dp[i][0] = dp[i-1][0] + grid[i][0]  
	}  
  
	// 填充剩余部分  
	for i := 1; i < rows; i++ {  
		for j := 1; j < cols; j++ {  
			dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]  
		}  
	}  
  
	return dp[rows-1][cols-1]  
}  
  
func min(a, b int) int {  
	if a < b {  
		return a  
	}  
	return b  
} 