public class MinimumCostForTickets {
        public static void main (String[] args) {
                int[] days = { 1, 4, 6, 7, 8, 20 };
                int[] costs = { 2, 7, 15 };

                System.out.println (mincostTickets (days, costs));
        }

        public static int mincostTickets (int[] days, int[] costs) {
                int[] dp = new int[days.length];

                if (days.length > 0)
                        return mincostTicketsUtils (days, costs, 0, dp);

                return 0;
        }

        private static int mincostTicketsUtils (int[] days, int[] costs, int i, int[] dp) {
                if (i >= days.length) {
                        return 0;
                }

                if (dp[i] != 0) {
                        return dp[i];
                }

                return dp[i] = Math.min (Math.min (mincostTicketsUtils (days, costs, i + 1, dp) + costs[0],
                        mincostTicketsUtils (days, costs, searchExactDay (days, i, days.length - 1, days[i] + 7), dp) + costs[1]),
                        mincostTicketsUtils (days, costs, searchExactDay (days, i, days.length - 1, days[i] + 30),
                                dp) + costs[2]);
        }

        private static int searchExactDay (int[] days, int left, int right, int key) {
                int mid = (left + right) / 2;

                if (days[mid] >= key && days[mid - 1] < key) {
                        return mid;
                } else if (key > days[mid] && left < right) {
                        return searchExactDay (days, mid + 1, right, key);
                } else if (key < days[mid] && left < right) {
                        return searchExactDay (days, left, mid - 1, key);
                }

                return right + 1;
        }
}
