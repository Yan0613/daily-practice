func sortColors(nums []int)  {
    mid := 0
    high := len(nums)-1
    low := 0
    for mid <= high {
        if nums[mid] == 0 {
            nums[mid], nums[low] = nums[low], nums[mid]
            low += 1
            mid += 1
        }else if nums[mid] == 1 {
            mid += 1
        }else {
            nums[mid], nums[high] = nums[high], nums[mid]
            high -= 1
        }
    }
}

// 这个问题可以使用荷兰国旗问题（Dutch National Flag problem）的解决策略，也称作三路划分（three-way partitioning）。我们可以使用三个指针：low、mid 和 high。

// low 指针指向当前已知的红色区域的末尾（下一个红色元素应该放在这里）。
// mid 指针用于遍历数组。
// high 指针指向当前已知的蓝色区域的开始（上一个蓝色元素在这里）。
// 在遍历过程中，我们根据 nums[mid] 的值更新指针：

// 如果 nums[mid] == 0（红色），则与 nums[low] 交换，然后 low 和 mid 都向右移动一位。
// 如果 nums[mid] == 1（白色），则只移动 mid 指针，因为白色元素已经位于正确的位置（红色和白色之间的区域）。
// 如果 nums[mid] == 2（蓝色），则与 nums[high] 交换，然后 high 向左移动一位（但注意，此时 mid 不移动，因为交换后的元素可能是红色或白色，需要再次检查）。
// 最后，当 mid 指针超过 high 指针时，遍历结束，数组已经被正确地排序为红色、白色、蓝色的顺序。