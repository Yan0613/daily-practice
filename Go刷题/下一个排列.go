func nextPermutation(nums []int)  {
    i := len(nums) - 2  
    for i >= 0 && nums[i] >= nums[i + 1] {
        i -= 1  
    }

    if i >= 0{
        j := len(nums) - 1  
        for j > i && nums[j] <= nums[i]{
            j -= 1  
        }
        nums[i], nums[j] = nums[j], nums[i]  
    }


    left, right := i + 1, len(nums) - 1  
    for left < right{
        nums[left], nums[right] = nums[right], nums[left]  
        left += 1  
        right -= 1
    }

}