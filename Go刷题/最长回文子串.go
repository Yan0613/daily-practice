func longestPalindrome(s string) string {  
	if len(s) < 2 {  
		return s  
	}  
  
	n := len(s)  
	dp := make([][]bool, n)  
	for i := range dp {  
		dp[i] = make([]bool, n)  
	}  
	  
	// 所有单个字符都是回文串  
	for i := 0; i < n; i++ {  
		dp[i][i] = true  
	}  
  
	start, maxLength := 0, 1  
	// L 表示子串的长度  
	for L := 2; L <= n; L++ {  
		// 遍历所有子串的起始位置  
		for i := 0; i <= n-L; i++ {  
			j := i + L - 1  
			if s[i] == s[j] && (L == 2 || dp[i+1][j-1]) {  
				dp[i][j] = true  
				// 如果找到更长的回文子串，则更新起始位置和长度  
				if L > maxLength {  
					start = i  
					maxLength = L  
				}  
			}  
		}  
	}  
  
	// 截取最长回文子串  
	return s[start : start+maxLength]  
}  