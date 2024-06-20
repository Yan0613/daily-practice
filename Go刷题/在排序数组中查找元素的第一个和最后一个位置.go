func searchRange(nums []int, target int) []int {
    res := []int{-1, -1}
	firstPos := binarySearch(nums, 0, len(nums)-1, true, target)
	lastPos := binarySearch(nums, 0, len(nums)-1, false, target)
	res[0] = firstPos
	res[1] = lastPos
	return res
}

func binarySearch(nums []int,left int, right int, findFirst bool, target int) int {
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			if findFirst {
				if mid == 0 || nums[mid-1] != target {
					return mid
				} else {
					right = mid - 1
				}
			} else {
				if mid == len(nums)-1 || nums[mid+1] != target {
					return mid
				} else {
					left = mid + 1
				}
			}
		} else if nums[mid] > target {
			right = mid - 1 
		} else {
			left = mid + 1
		}
	}
	return -1
}