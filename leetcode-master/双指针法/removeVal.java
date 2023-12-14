public class removeVal {
    /**
     * 双指针法移除元素
     * 
     * @param arr
     * @param val
     */
    public int removeVal(int[] arr, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < arr.length; fastIndex++) {
            if (arr[fastIndex] != val) {
                arr[slowIndex] = arr[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    /**
     * 左右双指针法
     * 
     * @param arr
     * @param val
     * @return
     */
    public int removeValleftright(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {

            // 左边找第一个等于要移除元素的
            while (left <= right && arr[left] != val) {
                left++;
            }

            // 右边找第一个不等于移除元素的
            while (left <= right && arr[right] == val) {
                right--;
            }

            // 左边的换成右边的
            if (left <= right) {
                arr[left] = arr[right];
                left++;
                right--;
            }
        }

        return left;// left一定指向最终数组末尾的下一个元素
    }
}
