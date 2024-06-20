class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)  
        dp = [[0] * (n + 1) for _ in range(m + 1)]  
        
        # 初始化dp数组  
        for i in range(m + 1):  
            dp[i][0] = i  
        for j in range(n + 1):  
            dp[0][j] = j  
        
        # 填充dp数组  
        for i in range(1, m + 1):  
            for j in range(1, n + 1):  
                if word1[i - 1] == word2[j - 1]:  
                    dp[i][j] = dp[i - 1][j - 1]  
                else:  
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1  
        
        return dp[m][n]
    
#     初始化一个(m+1) x (n+1)的二维数组dp，其中m和n分别是word1和word2的长度。将dp[i][0]设为i，因为将word1的前i个字符转换为空字符串需要i次删除操作；将dp[0][j]设为j，因为将空字符串转换为word2的前j个字符需要j次插入操作。
# 对于dp[i][j]（其中i > 0且j > 0），我们有三种选择：
# 如果word1[i-1] == word2[j-1]（即两个单词的当前字符相同），则不需要任何操作，dp[i][j] = dp[i-1][j-1]。
# 如果两个字符不同，我们可以选择插入、删除或替换操作，取这三种操作中的最小值，并加1（因为执行了一次操作）：
        # 插入：在word1的末尾插入word2[j-1]，即dp[i][j-1] + 1（对应于在word1中插入一个字符）。
        # 删除：从word1中删除word1[i-1]，即dp[i-1][j] + 1（对应于在word1中删除一个字符）。
        # 替换：将word1[i-1]替换为word2[j-1]，即dp[i-1][j-1] + 1（对应于在word1中替换一个字符）。
# 因此，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1（如果word1[i-1] != word2[j-1]）。
# 返回dp[m][n]，即从word1到word2的最少操作数。