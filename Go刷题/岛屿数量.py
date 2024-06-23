class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:  
            return 0  
    
        rows, cols = len(grid), len(grid[0])  
        count = 0  
    
        def dfs(r, c):  
            if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] != '1':  
                return  
            grid[r][c] = '#'  # 标记为已访问  
            dfs(r - 1, c)  # 上  
            dfs(r + 1, c)  # 下  
            dfs(r, c - 1)  # 左  
            dfs(r, c + 1)  # 右  
    
        for i in range(rows):  
            for j in range(cols):  
                if grid[i][j] == '1':  
                    count += 1  
                    dfs(i, j)  
    
        return count 
            