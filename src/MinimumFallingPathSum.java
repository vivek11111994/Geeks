public class MinimumFallingPathSum {
        public static void main (String[] args) {
                int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
                int res = minFallingPathSum (arr);
                System.out.println (res);
        }

        public static int minFallingPathSum (int[][] arr) {
                int sum = Integer.MAX_VALUE;

                for (int i = 0; i < arr.length; i++) {
                        sum = Math.min (sum, minFallingPathSumUtils (arr, 0, i, new int[arr.length][arr.length]));
                }

                return sum;
        }

        public static int minFallingPathSumUtils (int[][] arr, int row, int col, int[][] dp) {
                if (row == arr.length - 1) {
                        return arr[row][col];
                }

                if (dp[row][col] != 0) {
                        return dp[row][col];
                }

                int same = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if (row + 1 < arr.length) {
                        if (col < arr.length && col >= 0) {
                                same = minFallingPathSumUtils (arr, row + 1, col, dp);
                        }

                        if (col - 1 < arr.length && col - 1 >= 0) {
                                left = minFallingPathSumUtils (arr, row + 1, col - 1, dp);
                        }

                        if (col + 1 < arr.length && col + 1 >= 0) {
                                right = minFallingPathSumUtils (arr, row + 1, col + 1, dp);
                        }
                }

                return dp[row][col] = arr[row][col] + Math.min (same, Math.min (left, right));
        }
}
