package main

func intersection(nums1 []int, nums2 []int) []int {
	set := make(map[int]struct{}, 0) // 用map模拟set
	res := make([]int, 0)
	for _, v := range nums1 {
		if _, ok := set[v]; !ok {
			set[v] = struct{}{}
		}
	}
	// 这里，set是一个map，其键（key）是int类型，值（value）是struct{}类型。在Go中，struct{}是一个没有字段的空结构体，
	// 它通常用作map的值类型来模拟集合。因为空结构体不占用任何内存空间（除了map本身的开销），所以它是表示集合中元素存在性的有效方式。
	for _, v := range nums2 {
		//如果存在于上一个数组中，则加入结果集，并清空该set值
		if _, ok := set[v]; ok {
			res = append(res, v)
			delete(set, v) //如果不删除，一个值会出现多次比如，[1，2，3，4]和[2，2]会输出[2,2]而不是[2]
		}
	}
	return res
}
