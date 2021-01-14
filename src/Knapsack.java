public class Knapsack {
        public static void main (String[] args) {
        /*int t;
        System.
        int[][] dp = new int[weights.length+1][W+1];

        for(int i = 0; i <= weights.length; i++) {
            for(int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsack(weights, values, W, 0, 0, dp));*/
        }

        private static int knapsack (int[] weights, int[] values, int W, int w, int pos, int[][] dp) {
                if (pos == weights.length || w == W) {
                        return 0;
                }

                if (dp[pos + 1][w] != - 1) {
                        return dp[pos + 1][w];
                }

                if (w + weights[pos] <= W) {
                        return dp[pos + 1][w + weights[pos]] = Math.max (values[pos] + knapsack (weights, values, W,
                                w + weights[pos], pos + 1, dp),
                                knapsack (weights, values, W, w, pos + 1, dp));
                } else {
                        return dp[pos + 1][w] = knapsack (weights, values, W, w, pos + 1, dp);
                }
        }
}
