type MinHeap []int  
  
// 实现heap.Interface  
func (h MinHeap) Len() int { return len(h) }  
func (h MinHeap) Less(i, j int) bool { return h[i] < h[j] }  
func (h MinHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }  
  
// Push 方法，用于将元素添加到堆中  
func (h *MinHeap) Push(x interface{}) {  
	*h = append(*h, x.(int))  
}  
  
// Pop 方法，用于从堆中移除并返回最小元素  
func (h *MinHeap) Pop() interface{} {  
	old := *h  
	n := len(old)  
	x := old[n-1]  
	*h = old[:n-1]  
	return x  
}  
  
// findKthLargest 函数  
func findKthLargest(nums []int, k int) int {  
	pq := &MinHeap{}  
	heap.Init(pq)  
  
	for _, num := range nums {  
		heap.Push(pq, num)  
		if pq.Len() > k {  
			heap.Pop(pq)  
		}  
	}  
  
	return (*pq)[0] // 返回堆顶元素，即第k大的数  
}  
  