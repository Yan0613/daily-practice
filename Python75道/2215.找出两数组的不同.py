from ast import List


class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        set1 = set(nums1)   # nums1 所有元素的哈希集合
        set2 = set(nums2)   # nums2 所有元素的哈希集合
        res = [[], []]
        for num in set1:
            if num not in set2:
                res[0].append(num)
        for num in set2:
            if num not in set1:
                res[1].append(num)
        return res
#不懂意义在哪