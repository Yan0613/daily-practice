func numIslands(grid [][]byte) int {
    res := 0
    m := len(grid)
    n := len(grid[0])
    for row := 0 ; row < m ; row ++ {
        for col := 0; col < n ;col ++ {
            if grid[row][col] == '1' {
                dfs(grid,row,col)
                res ++
            }
        }
    }

    return res 

}

func dfs(grid [][]byte, r int, c int) {
    m := len(grid)
    n := len(grid[0])

    if r<0 || r >= m || c < 0 ||c >= n || grid[r][c] != '1' {
        return
    }
    grid[r][c] = '#' //标记为已访问
    dfs(grid, r-1,c)
    dfs(grid,r,c-1)
    dfs(grid,r+1,c)
    dfs(grid, r,c+1)
}