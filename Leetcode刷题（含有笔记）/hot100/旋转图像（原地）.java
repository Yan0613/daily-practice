class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 先进行转置操作
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                // 交换matrix[i][j]和matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 再水平翻转每一行
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                // 交换matrix[i][j]和matrix[i][n - j - 1]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
