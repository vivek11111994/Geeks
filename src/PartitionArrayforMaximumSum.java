public class PartitionArrayforMaximumSum {
        public static void main (String[] args) {
                int[] arr = { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 };
                int res = maxSumAfterPartitioning (arr, 4);

                System.out.println (res);
        }

        public static int maxSumAfterPartitioning (int[] arr, int K) {
                return maxSumAfterPartitioningUtils (arr, K, 0, 1, Integer.MIN_VALUE, new int[arr.length][K + 1]);
        }

        public static int maxSumAfterPartitioningUtils (int[] arr, int K, int i, int k, int max, int[][] dp) {
                if (i >= arr.length) {
                        return 0;
                }

                if (dp[i][k] != 0) {
                        return dp[i][k];
                }

                max = Math.max (max, arr[i]);

                int sum = maxSumAfterPartitioningUtils (arr, K, i + 1, 1, Integer.MIN_VALUE, dp) + k * max;

                if (k < K) {
                        sum = Math.max (sum, maxSumAfterPartitioningUtils (arr, K, i + 1, k + 1, max, dp));
                } else {
                        sum = Math.max (sum, maxSumAfterPartitioningUtils (arr, K, i + 1, 1, Integer.MIN_VALUE, dp));
                }

                dp[i][k] = sum;

                return sum;
        }
}
