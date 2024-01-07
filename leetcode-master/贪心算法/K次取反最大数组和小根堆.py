import heapq


class Solution(object):
    def largestSumAfterKNegations(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        heapq.heapify(nums)
        while k > 0:
            heapq.heappush(nums, -heapq.heappop(nums))
            k -= 1;
        return sum(nums)