func removeElement(nums []int, val int) int {
    size := len(nums)
    for i := 0; i < size; i ++ {
        if nums[i] == val {
            for j := i + 1; j < size; j ++ {
                nums[j - 1] = nums[j]
            }
            i --
            size --
        }
    }
    return size
}