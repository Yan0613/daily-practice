func search(nums []int, target int) int {
	left := 0
	right := len(nums) - 1
	for left <= right {
	    mid := (left + right) / 2
		if nums[left] == target {
			return left
		} else if nums[right] == target {
			return right
		} else if nums[mid] > target {
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		} 
	}
	return -1
}