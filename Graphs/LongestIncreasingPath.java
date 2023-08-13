class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[][] memo = new int[matrix.length][matrix[0].length];

        for (int m = 0; m < matrix.length; m ++ ){
            for (int n = 0; n < matrix[0].length; n++){
                int num = dfs(m, n, -1, matrix, memo);
                max = (num > max) ? num : max;  
            }
        }
        return max;
    }

    public static int dfs(int m, int n, int prev, int[][] matrix, int[][] memo){
        if (m < 0 || m >= matrix.length || n < 0 || n >= matrix[0].length) return 0;
        if (prev != -1 && matrix[m][n] >= prev) return 0;

        if (memo[m][n] != 0) return memo[m][n];

        int maxAt = 1 + max(dfs(m+1, n, matrix[m][n], matrix, memo),
                        dfs(m-1, n, matrix[m][n], matrix, memo),
                        dfs(m, n+1, matrix[m][n], matrix, memo),
                        dfs(m, n-1, matrix[m][n], matrix, memo));    

        memo[m][n] = maxAt;
        return maxAt;
    }

    public static int max(int a, int b, int c, int d) {

    int max = a;

    if (b > max) max = b;
    if (c > max) max = c;
    if (d > max) max = d;
     return max;
    }
}