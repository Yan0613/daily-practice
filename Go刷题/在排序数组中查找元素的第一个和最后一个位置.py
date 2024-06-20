class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarySearch(left, right, findFirst):  
            while left <= right:  
                mid = left + (right - left) // 2  // 防止溢出
                if nums[mid] == target:  
                    # 根据findFirst的值，确定向左还是向右搜索  
                    if findFirst:  
                        if mid == 0 or nums[mid - 1] != target:  
                            return mid  
                        else:  
                            right = mid - 1  
                    else:  
                        if mid == len(nums) - 1 or nums[mid + 1] != target:  
                            return mid  
                        else:  
                            left = mid + 1  
                elif nums[mid] < target:  
                    left = mid + 1  
                else:  
                    right = mid - 1  
            return -1  # 如果没有找到目标值  
    
        first_position = binarySearch(0, len(nums) - 1, True)  
        if first_position == -1:  
            return [-1, -1]  
        last_position = binarySearch(0, len(nums) - 1, False)  
        return [first_position, last_position]  