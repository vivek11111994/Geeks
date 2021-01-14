public class MinPathSum {
        private static final int[][] dp = { { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 } };

        public static void main (String[] args) {
                int[][] arr = { { 1, 3, 1 },
                        { 1, 5, 1 },
                        { 4, 2, 1 } };

                System.out.println (findPath (arr, 0, 0, 3, 3, 0));

                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                                System.out.print (dp[i][j] + " ");
                        }
                        System.out.println ();
                }
        }

        public static int findPath (int[][] arr, int i, int j, int r, int c, int sum) {
                if (i >= r || j >= c) {
                        return sum;
                }

                if (i == r - 1 && j == c - 1) {
                        return sum + arr[i][j];
                }

                if (dp[i][j] != 0) {
                        return dp[i][j];
                }

                return dp[i][j] = Math.min (findPath (arr, i + 1, j, r, c, sum + arr[i][j]), findPath (arr, i, j + 1, r, c, sum + arr[i][j]));
        }
}
