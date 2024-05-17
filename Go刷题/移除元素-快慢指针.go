func removeElement(nums []int, val int)  {
	slow := 0
	for fast := 0; fast < len(nums); fast++ {
	    // 遇到与 val 相等的元素，跳过
		if nums[fast] != val {
			nums[slow] = nums[fast]
			slow++
		}
		// 遇到与 val 相等的元素，slow 不变，fast 继续向前遍历
		// 这样相当于跳过了这个元素
		continue
	}
	return slow
}