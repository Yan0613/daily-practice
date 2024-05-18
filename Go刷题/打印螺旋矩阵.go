func spiralOrder(matrix [][]int) []int {
    if len(matrix) == 0 || len(matrix[0]) == 0 {
        return []int{}
    }
    
    m, n := len(matrix), len(matrix[0])
    res := make([]int, m*n)
    count := 0
    left, right := 0, n-1
    top, bottom := 0, m-1

    for left <= right && top <= bottom {
        // Traverse from left to right along the top row
        for j := left; j <= right; j++ {
            res[count] = matrix[top][j]
            count++
        }
        top++
        
        // Traverse from top to bottom along the right column
        for i := top; i <= bottom; i++ {
            res[count] = matrix[i][right]
            count++
        }
        right--
        
        // Make sure we are now on a different row
        if top <= bottom {
            // Traverse from right to left along the bottom row
            for j := right; j >= left; j-- {
                res[count] = matrix[bottom][j]
                count++
            }
            bottom--
        }
        
        // Make sure we are now on a different column
        if left <= right {
            // Traverse from bottom to top along the left column
            for i := bottom; i >= top; i-- {
                res[count] = matrix[i][left]
                count++
            }
            left++
        }
    }
    
    return res
}
