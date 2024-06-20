func searchMartrix([][]int matrix, int target) {
	m , n := len(matrix), len(matrix[0])
	left , right := 0, m * n - 1
	for left < right {
		mid := (left + right) >> 1
		midrow := mid / n
		midcol := mid % n
		if matrix[midrow][midcol] == target {
		    return true
		} else if matrix[midrow][midcol] > target {
		    right = mid - 1
		}	else {
		    left = mid + 1
		}
	}
	return false
}