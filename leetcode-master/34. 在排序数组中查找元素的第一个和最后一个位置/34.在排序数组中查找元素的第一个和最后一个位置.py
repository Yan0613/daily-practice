class Solution:
    def searchRange(self, nums, target):
        for i in range(len(nums)):
            if nums[i] == target:      # 遍历到目标值后，当前下标为左边界值
                for j in range(len(nums)-1, i-1, -1):    # 反向遍历数组到已遍历的位置，可以取到右边界值
                    if nums[j] == target:
                        return [i, j]
        return [-1, -1]       # 数组中不包含目标值