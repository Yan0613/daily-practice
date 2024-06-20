class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:  
            return False  
        
        m, n = len(matrix), len(matrix[0])  
        left, right = 0, m * n - 1  
        
        while left <= right:  
            mid = (left + right) // 2  
            midRow, midCol = divmod(mid, n)  # 将一维索引转换为二维索引  
            midVal = matrix[midRow][midCol]  
            
            if midVal == target:  
                return True  
            elif midVal < target:  
                left = mid + 1  
            else:  
                right = mid - 1  
        
        return False  