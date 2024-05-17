func sortedSquares(nums []int) []int {
    n := len(nums)
	i,j,k := 0,n-1,n-1
	//i,j分别指向数组的两端，K是结果集下标
	ans := make([]int,n)
	for i<=j {
	    if nums[i]*nums[i] > nums[j]*nums[j] {
	        ans[k] = nums[i]*nums[i]
	        i++
	    }else{
	        ans[k] = nums[j]*nums[j]
	        j--
	    }
	    k--
	}
}