package main

func findMin(nums []int) int {
	left, right := -1, len(nums)-1 // 开区间 (-1, n-1)
	for left+1 < right {           // 开区间不为空
		mid := left + (right-left)/2
		if nums[mid] < nums[len(nums)-1] { // 蓝色
			right = mid
		} else { // 红色
			left = mid
		}
	}
	return nums[right]
}
